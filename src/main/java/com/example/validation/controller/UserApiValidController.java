package com.example.validation.controller;

import com.example.exception.model.ApiValid;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/valid/api/user")
public class UserApiValidController {
    // Api를 통해서만 JSON을 보낼 수 있음
    @PostMapping("")
    // 여러 형태의 return 값을 넘기기 위해 -> generic의 wildcard( ? )를 사용 : 모든 class는 Object를 상속받기 때문에 사용 가능
    public ApiValid<UserRegisterRequest> register(
//    public ApiValid< ? extends Object> register(
            @Valid
            @RequestBody
            ApiValid<UserRegisterRequest> userRegisterRequest
//            BindingResult bindingResult  // Error를 잡는 방법 BindingResult 추가
    ){
        log.info("\ninit ===== \n{} ", userRegisterRequest);

        var body = userRegisterRequest.getData();

        var response = ApiValid.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;

        /* 2024.09.18 [ mod-hs ] ValidationExceptionHandler.java로 옮김
        // Error 방지 코드 추가
       if( bindingResult.hasErrors()){
            var errorMessageList = bindingResult.getFieldErrors().stream()
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
            return errorResponse;
        }*/
    }
}
