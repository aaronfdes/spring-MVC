package com.training.spring.mvc.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MyNameValidator.class)
public @interface NameValidator {

	public String startsWith();

	public String message() default "my validation message for name validator";

	public abstract Class[] groups() default {};

	public abstract Class[] payload() default {};
}
