package com.cinema.model.dto.request;

import com.cinema.lib.ValidEmail;
import com.cinema.lib.ValidPasswords;
import javax.validation.constraints.NotNull;

@ValidPasswords(password = "password",
        repeatPassword = "repeatPassword")
public class UserRequestDto {
    @NotNull(message = "'email' field cannot be empty!")
    @ValidEmail
    private String email;
    @NotNull(message = "'password' field cannot be empty!")
    private String password;
    @NotNull(message = "'repeatPassword' field cannot be empty!")
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
