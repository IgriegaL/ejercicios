package com.springbootform.form.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Requerido {
	// Copiados de @NotBlanck y cambiamos el mensaje
	String message() default "Campo apelido es requerido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
