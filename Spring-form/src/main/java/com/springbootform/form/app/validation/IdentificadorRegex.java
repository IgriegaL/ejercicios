package com.springbootform.form.app.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IdentificadorRegexValidador.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentificadorRegex {
	/* Añadimos la validación, pero para hacerlo sencillo, 
	 * vamos a nuestra clase y control mas clic sobre cualquier Anotación de validación 
	 * como @NotEmpty, y copiamos sus validaciones 
	 * */
	String message() default "{jakarta.validation.constraints.NotEmpty.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
