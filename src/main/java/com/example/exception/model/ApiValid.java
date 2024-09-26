package com.example.exception.model;

/*
우리가 항상 서베에서 내리고자 하는 class
 */

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 항상 해당 클래스는 Snake case로 답변이 가도록 지정
@JsonNaming( value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ApiValid<T> {
    private String resultCode;
    private String resultMessage;

    @Valid
    private T data;

    private Error error;

    /* inner class 생성 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming( value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Error{
        private List<String> errorMessage;
    }
}
