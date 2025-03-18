package com.jbt.qrstorage.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginBodyDto {

    @NotEmpty(message = "Missing email")
    private String email;

    @NotEmpty(message = "Missing password")
    private String password;

}
