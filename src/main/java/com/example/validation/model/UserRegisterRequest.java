package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming( value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
//    @NotNull      // != null
//    @NotEmpty     // != null &&* name != ""
//    @NotBlank(message = "name은 필수 값 입니다.")       // != null && namme != "" && name != " "\
    private String name;
    private String nickName;

    @Size( min = 1 , max = 12 )
    @NotBlank
    private String password;

    @NotNull        // integer 형이라 NotBlack 적용 못함
    @Min(1)
    @Max(100)
    private Integer age;

    @Email      // email fotmat 형으로 들어오도록
    private String email;

    // 직접 만든 PhoneNumber annotation 사용
    @PhoneNumber
//    @Pattern( regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$" , message = "휴대폰 번호 양식에 맞지 않습니다.")      // 핸드폰 번호는 정규식을 통해서 문자열 지정 ( error )
    private String phoneNumber;

    @YearMonth( pattern = "yyyy-MM")
    private String yearMonth;

    @FutureOrPresent        // 현재 또는 그 이상을 뜻함
    private LocalDateTime registerAt;

    // 복합적인 조건을 사용할 경우
    // AssertTrue는 반드시 메서드 name 앞에 `is`를 붙여줘야 함
    // name or nickName 둘 중 하나라도 있어야 통과 시키는 validation 작성
    @AssertTrue(message = "name or nickName은 존재해야 합니다.")
    public boolean isNameCheck(){
        if (Objects.nonNull(name) && !name.isBlank()) {
            return true;
        }

        if( Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }
        return false;
    }
}
