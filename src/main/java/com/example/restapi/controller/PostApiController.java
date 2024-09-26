package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @PostMapping("/post")
    // @RequestBodys는 BookRequest에 mapping 역할을 한다.
    public BookRequest post(@RequestBody BookRequest bookRequest) {
        // 응답이 json 형태로 return됨
        return bookRequest;
    }

    @PostMapping("/user")
    public void User(
        @RequestBody UserRequest userRequest
    ){
        System.out.println("userRequest = " + userRequest);
    }
}
