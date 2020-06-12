package com.cinema.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchValidator implements ConstraintValidator<ValidPasswords, Object> {

    private String password;
    private String repeatPassword;

    @Override
    public void initialize(ValidPasswords constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.repeatPassword = constraintAnnotation.repeatPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object passValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object repeatPassValue = new BeanWrapperImpl(value).getPropertyValue(repeatPassword);
        if (passValue != null) {
            return passValue.equals(repeatPassValue);
        } else {
            return repeatPassValue == null;
        }
    }
}
