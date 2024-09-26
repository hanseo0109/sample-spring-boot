package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import javax.lang.model.SourceVersion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
public class YearMonthValidator implements ConstraintValidator<YearMonth , String> {
    private String pattern;

    @Override
    public void initialize(YearMonth yearMonth) {
        // 기본 패턴 생성
        this.pattern = yearMonth.pattern();
    }

    /**
     * client request : 2024-09-25T20:00:00" , yyyy-MM-ddTHH:mm:ss
     * @param value
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if( value == null || value.isEmpty()){
            // 값이 없으면 검증 패스
            return true;
        }

        try{
            // me
//            java.time.YearMonth.parse( value , DateTimeFormatter.ofPattern( pattern ) );
            int size = new String( value ).length();
            log.info("\nsize : " + size);

            LocalDate date = null;

            // teach
            if( size > 6 && size <= 8 ){
                date = LocalDate.parse( value , DateTimeFormatter.ofPattern(pattern) );

            } else if (size == 6) {
                date = LocalDate.parse( value + "09", DateTimeFormatter.ofPattern(pattern + "dd") );
            }

            System.out.println("date = " + date);

            // 변환에 성공하면 유효 값 넘김
            return true;
        } catch ( DateTimeParseException e) {
            return false;
        }
    }
}
