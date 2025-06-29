package ru.arooid.financial.account.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Serdeable
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"password"})
public class UserDto {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;

    public UserDto(String username,
                   String firstname,
                   String lastname,
                   String email,
                   String phone,
                   String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserDto(String username,
                   String firstname,
                   String lastname,
                   String email,
                   String phone) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

}
