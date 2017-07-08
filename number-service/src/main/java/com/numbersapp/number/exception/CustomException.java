package com.numbersapp.number.exception;

/**
 * Created by sepulrator on 08.07.2017.
 */
public class CustomException extends Exception {

    private String errorCode;
    private String message;

    public CustomException(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
