package com.tajad.automata_work.domain.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Pattern(regexp = "[A-Z][a-z]+( [A-Z][a-z]+)? [A-Z][a-z]+", message = "Name pattern is wrong.")
    public String name;

    @Pattern(regexp = "\\w+@\\w+[.]+[\\w|.]{2,}", message = "Email pattern is wrong.")
    private String email;

    @Pattern(regexp = "(?=\\w*[A-Za-z])(?=\\w*\\d)[A-Za-z0-9]{8}", message = "Password pattern is wrong.")
    private String password;

    @Pattern(regexp = "([0-9]{3}.){2}[0-9]{3}-[0-9]{2}", message = "Cpf pattern is wrong.")
    private String cpf;

    @Pattern(regexp = "([(][0-9]{2}[)] 9[0-9]{4}-?|[0-9]{2} 9[0-9]{4})[0-9]{4}", message = "PhoneNumber pattern is wrong.")
    private String phoneNumber;

    @Pattern(regexp = "([0-9]{2}/){2}[0-9]{4} ([0-9]{2}:){2}[0-9]{2}", message = "Date pattern is wrong.")
    private String date;

    @Pattern(regexp = "(-|[+])?[0-9]+([.][0-9]+)?", message = "RandomValue pattern is wrong.")
    private String randomValue;
}
