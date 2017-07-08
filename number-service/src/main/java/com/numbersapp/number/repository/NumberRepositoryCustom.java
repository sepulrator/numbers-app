package com.numbersapp.number.repository;

import com.numbersapp.number.entity.NumberEntity;

/**
 * Created by sepulrator on 08.07.2017.
 */
interface NumberRepositoryCustom {

    NumberEntity getMaxNumber();
    NumberEntity getMinNumber();
}
