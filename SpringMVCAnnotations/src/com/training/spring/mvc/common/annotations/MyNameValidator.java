package com.training.spring.mvc.common.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyNameValidator implements ConstraintValidator<NameValidator, String>{

	private String startsWith;
	
	@Override
	public void initialize(NameValidator validator) {
		startsWith = validator.startsWith();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.startsWith(startsWith)){
			return true;
		}
		return false;
	}

}
