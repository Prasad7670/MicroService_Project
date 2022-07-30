package com.neoquant.valid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    private int id;
    @NotNull(message = "username should not be null")
    private String name;
    @Email(message = "Invalid email Address")
    private String email;
    @NotNull(message = "Mobile Number range btn 1-10")
    @Pattern(regexp = "^\\d{10}$")
    private String mobileNumber;
    @Min(18)
    @Max(55)
    private int age;
    @NotBlank
    private String nationality;
}
