package com.example.exception.controller;

import com.example.exception.model.ApiValid;
import com.example.exception.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    /*
    이제는 builder pattern 사용
           .setXXX1
            .setXXX2
    이런식으로 선언하는게 아니라 `chain`인 된 방식으로 마치 한 가지를 빌드하듯이 이어지는 패턴이 builder pattern이라고 한다.
    */

    // Builder pattern 사용하여 `객체` 생성
    private List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("test1")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(20)
                    .name("test2")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public ApiValid<UserResponse> getUser(
            @PathVariable String userId
    ) {
        if (true) {
            throw new RuntimeException("message");
        }

        var user = userList.stream()
                .filter(
                        it -> it.getId().equals(userId)
                )
                .findFirst()
                .get();

        ApiValid<UserResponse> response = ApiValid.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;
    }
}
