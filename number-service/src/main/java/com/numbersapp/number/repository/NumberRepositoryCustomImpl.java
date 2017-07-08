package com.numbersapp.number.repository;

import com.numbersapp.number.entity.NumberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by sepulrator on 08.07.2017.
 */
public class NumberRepositoryCustomImpl implements NumberRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public NumberEntity getMaxNumber() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "number"));
        query.limit(1);
        NumberEntity maxNumber = mongoTemplate.findOne(query, NumberEntity.class);
        return maxNumber;
    }

    @Override
    public NumberEntity getMinNumber() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "number"));
        query.limit(1);
        NumberEntity minNumber = mongoTemplate.findOne(query, NumberEntity.class);
        return minNumber;
    }
}
