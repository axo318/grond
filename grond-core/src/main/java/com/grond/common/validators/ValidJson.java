package com.grond.common.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidJsonValidator.class)
public @interface ValidJson {
    String message() default "Invalid JSON format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}