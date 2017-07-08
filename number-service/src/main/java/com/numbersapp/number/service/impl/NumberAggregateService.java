package com.numbersapp.number.service.impl;

import com.numbersapp.number.dto.converter.NumberConverter;
import com.numbersapp.number.dto.domain.NumberDTO;
import com.numbersapp.number.entity.NumberEntity;
import com.numbersapp.number.exception.RecordNotFoundException;
import com.numbersapp.number.repository.NumberRepository;
import com.numbersapp.number.service.IAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by sepulrator on 08.07.2017.
 */
@Service
public class NumberAggregateService implements IAggregateService<NumberDTO,Long> {

    private final static int PAGE_SIZE = 3;

    @Autowired
    NumberRepository numberRepository;

    @Autowired
    NumberConverter numberConverter;

    @Override
    public NumberDTO getMaxEntity() throws RecordNotFoundException {
        NumberEntity maxNumber = numberRepository.findTopByOrderByNumberDesc();
        if (maxNumber == null) {
            throw new RecordNotFoundException();
        }
        return numberConverter.convertBack(maxNumber);
    }

    @Override
    public NumberDTO getMinEntity() throws RecordNotFoundException {
        NumberEntity minNumber = numberRepository.findTopByOrderByNumberAsc();
        if (minNumber == null) {
            throw new RecordNotFoundException();
        }
        return numberConverter.convertBack(minNumber);
    }
}
