package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import com.example.validation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = YearMonthValidator.class)
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
//@Target({ElementType.FIELD , ElementType.PARAMETER})
public @interface YearMonth {
    String message() default "유효한 연월을 입력해야 합니다. ( yyyy-MM 형식 )";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // 패턴을 입력할 수 있도록 설정 ( 기본은 "yyyy-MM" )
    String pattern() default "yyyyMMdd";
}
