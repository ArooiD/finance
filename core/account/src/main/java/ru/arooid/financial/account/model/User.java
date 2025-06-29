package ru.arooid.financial.account.model;

import io.micronaut.core.annotation.Generated;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.ObjectMapper;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;
import ru.arooid.financial.account.dto.UserDto;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Serdeable
@MappedEntity
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Generated
    @Nullable
    private UUID id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String password;

    public User(String username, String firstname, String password) {
        this.username = username;
        this.firstname = firstname;
        this.password = password;
    }

    public User(UUID id, String username, String firstname, String password) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.password = password;
    }

    public User(UserDto dto) {
        this.username = dto.getUsername();
        this.firstname = dto.getFirstname();
        this.lastname = dto.getLastname();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();

        this.id = UUID.nameUUIDFromBytes((this.username + "|" + this.password).getBytes(StandardCharsets.UTF_8));
    }

    public String toJson() {
        try {
            return ObjectMapper.getDefault().writeValueAsString(this);
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }

}
