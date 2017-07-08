package com.numbersapp.number.service.impl;

import com.numbersapp.number.common.OrderType;
import com.numbersapp.number.dto.converter.NumberConverter;
import com.numbersapp.number.dto.domain.NumberDTO;
import com.numbersapp.number.entity.NumberEntity;
import com.numbersapp.number.exception.RecordNotFoundException;
import com.numbersapp.number.repository.NumberRepository;
import com.numbersapp.number.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by sepulrator on 08.07.2017.
 */
@Service
public class NumberCrudService implements ICrudService<NumberDTO,Long> {

    private final static int PAGE_SIZE = 3;

    @Autowired
    NumberRepository numberRepository;

    @Autowired
    NumberConverter numberConverter;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public NumberDTO create(NumberDTO item) {
        NumberEntity numberEntity = numberConverter.convert(item);
        numberEntity.setInsertDate(sdf.format(new Date()));
        numberRepository.insert(numberEntity);
        return numberConverter.convertBack(numberEntity);
    }

    @Override
    public NumberDTO read(Long id) {
        NumberEntity numberEntity = numberRepository.findOne(id);
        if (numberEntity == null) {
            throw new RecordNotFoundException();
        }
        return numberConverter.convertBack(numberEntity);
    }

    @Override
    public NumberDTO update(NumberDTO item) {
        NumberEntity numberEntity = numberConverter.convert(item);
        numberRepository.save(numberEntity);
        return numberConverter.convertBack(numberEntity);
    }

    @Override
    public void delete(Long id) {
        NumberEntity numberEntity = numberRepository.findOne(id);
        if (numberEntity == null) {
            throw new RecordNotFoundException();
        }
        numberRepository.delete(id);
    }

    @Override
    public List<NumberDTO> getList(OrderType orderType) {
        List<NumberEntity> numberEntityList = new ArrayList<>();
        switch (orderType) {
            case ASCENDING:
                numberEntityList = numberRepository.findAllByOrderByNumberAsc();
                break;
            case DESCENDING:
                numberEntityList = numberRepository.findAllByOrderByNumberDesc();
                break;
            default:
                break;
        }

        return numberEntityList.stream().map(entity -> numberConverter.convertBack(entity)).collect(Collectors.toList());
    }

}
