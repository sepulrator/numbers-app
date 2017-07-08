package com.numbersapp.number.repository;

import com.numbersapp.number.entity.NumberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by sepulrator on 08.07.2017.
 */
public interface NumberRepository extends MongoRepository<NumberEntity,Long>{

    NumberEntity findTopByOrderByNumberAsc();

    NumberEntity findTopByOrderByNumberDesc();

    List<NumberEntity> findAllByOrderByNumberAsc();

    List<NumberEntity> findAllByOrderByNumberDesc();



}
