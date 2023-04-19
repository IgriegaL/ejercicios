package com.springbootform.form.app.validation;

import com.springbootform.form.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // Si la clase es asignable a clazz, está correcto
        // Con esto nos aseguramos que lo que estamos validando es del tipo del usuario
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","NotEmpty.usuario.nombre");
    }
}
