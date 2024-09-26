package com.example.validation.exception;

import com.example.validation.model.ApiValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@Order(1)
public class ValidationExceptionHandler {

    @ExceptionHandler( value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiValid> validationException(
            MethodArgumentNotValidException exception
    ){
        log.error("\nValidationExceptionHandler ====== \n {}", exception.getMessage() );

        var errorMessageList = exception.getFieldErrors().stream()
                .map(it -> {
                    // 여기서 message는 responce body에 표시할 내용
                    var format = "%s : { %s } 은 %s";
                    var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
                    return message;
                }).collect(Collectors.toList());

        var error = ApiValid.Error
                .builder()
                .errorMessage(errorMessageList)
                .build();

        var errorResponse = ApiValid
                .builder()
                .resultCode( String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .error( error )
                .build();

        return ResponseEntity
                .status( HttpStatus.BAD_REQUEST )
                .body(errorResponse);
    }
}
