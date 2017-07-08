package com.numbersapp.number.common;

/**
 * Created by sepulrator on 08.07.2017.
 */
public enum OrderType {
    ASCENDING("ASC"),
    DESCENDING("DESC");

    private String value;
    public String getValue() {
        return value;
    }
    private OrderType(String value) {
        this.value = value;
    }
    }
