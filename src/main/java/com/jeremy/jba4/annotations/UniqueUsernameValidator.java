package com.jeremy.jba4.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeremy.jba4.repositories.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
	
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		if(userRepository==null){
			return true;
		}
		
		
		return userRepository.findByName(name)==null;
	}

}
