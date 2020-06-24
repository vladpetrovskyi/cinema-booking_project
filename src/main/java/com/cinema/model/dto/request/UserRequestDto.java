package com.cinema.model.dto.request;

import com.cinema.lib.ValidEmail;
import com.cinema.lib.ValidPasswords;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
