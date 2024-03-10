package com.grond.common.validators;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidJsonValidator implements ConstraintValidator<ValidJson, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean isValid(String jsonString, ConstraintValidatorContext context) {
        try {
            objectMapper.readTree(jsonString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
