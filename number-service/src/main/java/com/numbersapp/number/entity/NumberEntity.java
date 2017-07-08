package com.numbersapp.number.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by sepulrator on 08.07.2017.
 */
@Document(collection = "numbers")
public class NumberEntity {

    @Id
    @Field("number")
    private Long number;

    @Field("insertDate")
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

    @Override
    public String toString() {
        return "NumberDTO {" +
                "number=" + number + "" +
                ", insertDate ='" + insertDate + '\'' +
                '}';
    }
}
