package com.numbersapp.number.common;

import com.numbersapp.number.exception.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sepulrator on 08.07.2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT,reason="Record Already Exists")
    public ResponseEntity<Exception> handleDuplicateKeyException(DuplicateKeyException exception) {
        log.info("Returning HTTP 409 Conflict",exception);
        return new ResponseEntity<Exception>(exception, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason="Record Not Found")
    public ResponseEntity<Exception> handleRecordNotFoundException(RecordNotFoundException exception) {
        log.info("Returning HTTP 404 Not Found",exception);
        return new ResponseEntity<Exception>(exception, HttpStatus.NOT_FOUND);
    }

}
