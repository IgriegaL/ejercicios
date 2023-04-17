package com.springbootform.form.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {

    @Override
    public void initialize(IdentificadorRegex constraintAnnotation) {
        // inicialización del validador
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // lógica de validación
        return value != null && value.matches("[a-zA-Z0-9]+");
    }
}

