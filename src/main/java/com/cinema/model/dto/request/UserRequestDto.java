package com.cinema.model.dto.request;

import com.cinema.lib.ValidEmail;
import com.cinema.lib.ValidPasswords;
import javax.validation.constraints.NotNull;

@ValidPasswords(password = "password",
        repeatPassword = "repeatPassword")
public class UserRequestDto {
    @NotNull
    @ValidEmail
    private String email;
    @NotNull
    private String password;
    @NotNull
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
