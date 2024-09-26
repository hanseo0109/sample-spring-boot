package com.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {
    // localhost:8080/api/b/hello
    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("number format exception");
    }

    // /api/b/hello에 mapping된 메서드를 호출하는게 아닌 ExceptionHandler가 우선적으로 호출 됨
    @ExceptionHandler(value={NumberFormatException.class})
    public ResponseEntity numberFormatException(
            Exception e
    ){
        log.error("RestApiController", e);
        return ResponseEntity.ok().build();
    }
}
