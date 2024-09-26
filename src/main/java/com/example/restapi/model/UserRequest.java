package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
// snake case 로 요청이 들어오면 매핑시켜주는 역할을 함
 @JsonNaming( value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String userName;
    private Integer userAge;

//    @JsonProperty("user_email")
    private String email;
    // primitive type은 default 값이 false이기 때문에 데이터가 없을때 null 처리를 하지 못하므로
    //  reference type을 사용
    private Boolean isKorean;

    /*public String getName(){
        return this.userName;
    }

    public int getHumanAge(){
        return this.userAge;
    }*/

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getKorean() {
        return isKorean;
    }

    // default 생성자를 private으로 선언
    private UserRequest(){
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", email='" + email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }

    /*@JsonIgnore
    public String getUser(){
        return userName;
    }*/
}
