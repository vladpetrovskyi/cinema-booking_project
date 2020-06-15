package com.cinema.lib;

import com.cinema.model.dto.request.UserRequestDto;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchValidator implements ConstraintValidator<ValidPasswords, UserRequestDto> {

    private String password;
    private String repeatPassword;

    @Override
    public void initialize(ValidPasswords constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.repeatPassword = constraintAnnotation.repeatPassword();
    }

    @Override
    public boolean isValid(UserRequestDto value, ConstraintValidatorContext context) {
        Object passValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object repeatPassValue = new BeanWrapperImpl(value).getPropertyValue(repeatPassword);
        return Objects.equals(passValue, repeatPassValue);
    }
}
