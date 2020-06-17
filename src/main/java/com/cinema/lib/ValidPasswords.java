package com.cinema.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPasswords {
    String message() default "Passwords do not match!";
    String password();
    String repeatPassword();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
