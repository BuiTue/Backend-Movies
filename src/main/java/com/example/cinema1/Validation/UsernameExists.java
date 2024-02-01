package com.example.cinema1.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = com.example.cinema1.Validation.UsernameExistsValidator.class)
public @interface UsernameExists {

    String message() default "Username đã tồn tại";


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
