package com.numbersapp.number.service;

import com.numbersapp.number.exception.RecordNotFoundException;

import java.util.List;

public interface IAggregateService<T,K> {

    public T getMaxEntity();
    public T getMinEntity();

}