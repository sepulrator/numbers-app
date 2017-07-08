package com.numbersapp.number.service;

import com.numbersapp.number.common.OrderType;
import com.numbersapp.number.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICrudService<T,K> {

    public T create(T item);
    public T read(K id);
    public T update(T item);
    public void delete(K id);
    public List<T> getList(OrderType orderType);

}