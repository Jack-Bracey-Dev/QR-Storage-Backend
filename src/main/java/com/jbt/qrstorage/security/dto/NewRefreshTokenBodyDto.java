package com.jbt.qrstorage.security.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewRefreshTokenBodyDto {

    @NotEmpty
    private String token;

}
