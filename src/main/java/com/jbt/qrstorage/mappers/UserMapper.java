package com.jbt.qrstorage.mappers;

import com.jbt.qrstorage.dto.AuthUserDto;
import com.jbt.qrstorage.entity.AuthUser;
import com.jbt.qrstorage.enums.Role;
import com.jbt.qrstorage.security.dto.RegistrationBodyDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.NONE)
public class UserMapper {

    public static AuthUser mapToAuthUser(RegistrationBodyDto registrationBodyDto, PasswordEncoder encoder) {
        String encryptedPassword = encoder.encode(registrationBodyDto.getPassword());

        return AuthUser.builder()
                .email(registrationBodyDto.getEmail())
                .password(encryptedPassword)
                .roles(new ArrayList<>(List.of(Role.USER_ROLE)))
                .build();
    }

    public static AuthUserDto mapToAuthUserDto(AuthUser authUser) {
        return AuthUserDto.builder()
                .email(authUser.getEmail())
                .roles(authUser.getRoleNames())
                .build();
    }
}
