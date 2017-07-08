package com.numbersapp.number.dto.converter;

import com.numbersapp.number.dto.domain.NumberDTO;
import com.numbersapp.number.entity.NumberEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sepulrator on 08.07.2017.
 */
@Component
public class NumberConverter extends AbstractTwoWayConverter<NumberDTO, NumberEntity> {
    @Override
    public NumberEntity convert(NumberDTO source) {
        NumberEntity numberEntity = new NumberEntity();
        numberEntity.setNumber(source.getNumber());
        numberEntity.setInsertDate(source.getInsertDate());
        return numberEntity;
    }

    @Override
    public NumberDTO convertBack(NumberEntity target) {
        NumberDTO number = new NumberDTO();
        number.setNumber(target.getNumber());
        number.setInsertDate(target.getInsertDate());
        return number;
    }
}
