package pl.maciejpajak.dto;

import org.hibernate.validator.constraints.NotBlank;

import pl.maciejpajak.dto.validator.PasswordMatches;
import pl.maciejpajak.dto.validator.ValidEmail;

@PasswordMatches
public class UserDto {
    
    @NotBlank
    @ValidEmail
    private String email;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String surname;
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String passwordRepetition;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepetition() {
        return passwordRepetition;
    }

    public void setPasswordRepetition(String passwordRepetition) {
        this.passwordRepetition = passwordRepetition;
    }

}
