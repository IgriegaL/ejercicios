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
        // Con este paso podemos ahora validar los campos de usuario
        // Y los errores se pasan a través de errors
        //Usuario usuario = (Usuario) target;
        // Usamos ValidationUtils y su metodo reject is Empty para saber si está vacío el campo.
        // (error, atributodelobjeto , string registrado en messages.properties)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","NotEmpty.usuario.nombre");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido","NotEmpty.usuario.apellido");
        // Validar identificador matches con formato es igual false
        /*if (!usuario.getIdentificador().matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")) {
            errors.rejectValue("identificador","pattern.usuario.identificador");
        }*/

    }
}
