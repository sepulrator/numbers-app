package com.numbersapp.number.dto.domain;

import java.util.Date;

/**
 * Created by sepulrator on 08.07.2017.
 */
public class NumberDTO {
    private Long number;
    private String insertDate;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
}
