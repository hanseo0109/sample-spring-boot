package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello SpringBoot";
    }

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message) {
        System.out.println("message = " + message);
        return message;
    }

    @GetMapping("/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable String message,
            @PathVariable int age,
            @PathVariable boolean isMan
    ) {
        System.out.println("message = " + message);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);

        // TODO 대문자로 변환해서 return -> toUpperCase
        return message.toUpperCase();
    }

    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam( name = "issued-month") String issuedMonth,
            @RequestParam String issued_day
    ){
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
         System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issued_day = " + issued_day);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println("bookQueryParam = " + bookQueryParam);
    }
}
