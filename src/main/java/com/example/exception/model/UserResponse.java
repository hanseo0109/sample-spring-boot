package com.example.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 항상 해당 클래스는 Snake case로 답변이 가도록 지정
@JsonNaming( value = PropertyNamingStrategies.SnakeCaseStrategy.class)
// 객체를 생성할때는 Builder pattern 사용
@Builder
public class UserResponse {
    private String id;
    private int age;
    private String name;
}
