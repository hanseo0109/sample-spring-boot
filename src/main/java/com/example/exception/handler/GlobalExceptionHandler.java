package com.example.exception.handler;

import com.example.exception.model.ApiValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
    GloabalExceptionnHandler가 RestApiExceptionHandler보다 더 이후에 수행되도록
 */
@Slf4j
@RestControllerAdvice
//@Order(1)
public class GlobalExceptionHandler {
//    @ExceptionHandler( value = { Exception.class })
    public ResponseEntity<ApiValid> exception(
            Exception e
    ){
        log.error("", e);

        var response = ApiValid.builder()
                .resultCode(String.valueOf((HttpStatus.INTERNAL_SERVER_ERROR.value())))
                .resultMessage( HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
