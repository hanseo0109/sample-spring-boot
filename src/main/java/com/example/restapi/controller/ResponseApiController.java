/*
package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller     // html응답을 내려줄때 사용( 기존 spring 방식 )
//@RestController  //Json response를 내려줄때 사용
@RequestMapping("/api/v1")
public class ResponseApiController {
    // object return
    @GetMapping("")
    public UserRequest user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");
        return user;
    }

    // String return
    @GetMapping("/str")
    public String strUser(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");
        return user.toString();
    }

    // object return with ResponseEntity
//    @GetMapping("/response_entity")
    @RequestMapping(path="/use_entity", method = RequestMethod.GET)        // 만약 method를 명시하지 않으면 모든 요청을 다 받겠다는 뜻
    public ResponseEntity<UserRequest> userWithResponseEntity(){

        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");
        user.setIsKorean(true);

        log.info("user : {} ", user);

        var response = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-custom" , "hi")
                .body(user);

        return response;
    }

    // ResponseBody는 Controller의 응답을 -> JSON으로 내려주는 역할을 한다
    // + 만약 Controller 사용 시 ResponseBody가 없으면 404 error 발생 됨
    @GetMapping(path = "/use_controller")
    @ResponseBody
    public UserRequest userControllerResponse(){

        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@gmail.com");
        user.setIsKorean(true);

        log.info("user : {} ", user);

        var response = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-custom" , "hi")
                .body(user);

        return user;
    }
}
*/
