package com.example.exception.handler;

import com.example.exception.model.ApiValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
//@Order(2)   // exception 우선 순위 지정 ( 동일한 exception이 존재할 경우 order를 통해 순서를 구분할 수 있다. )
/*
    order 값을 통해서 글로벌 리셉션 핸들러보다는 해당 rest api 리셉션 핸들러가 먼저 동작할 수 있도록 order 값을 지정

 */
public class RestApiExceptionHandler {

    // GlobalHandlerException
    @ExceptionHandler( value = { Exception.class })
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
    /*@ExceptionHandler( value = {Exception.class})
    public ResponseEntity exception(
        Exception e
    ){
        log.error( "RestApi Exception", e);
        return ResponseEntity.status(200).build();
    }*/

    @ExceptionHandler( value = { IndexOutOfBoundsException.class })
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException " , e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler( value = {NoSuchElementException.class})
    public ResponseEntity<ApiValid> noSuchElement(
        NoSuchElementException e
    ){
        log.error( "NoSuchElementException" , e);
        var response = ApiValid.builder()
                .resultCode( String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        // 오류일 경우 404 오류 코드를 발생시키기 위함
        return ResponseEntity
                .status( HttpStatus.NOT_FOUND )
                .body(response);
    }

}
