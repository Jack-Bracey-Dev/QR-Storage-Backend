package com.jbt.qrstorage.security.controller;

import com.jbt.qrstorage.common.dto.AuthUserDto;
import com.jbt.qrstorage.security.dto.NewRefreshTokenBodyDto;
import com.jbt.qrstorage.security.dto.RegistrationBodyDto;
import com.jbt.qrstorage.security.dto.UserLoginBodyDto;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface IAuthenticationService {
    Mono<AuthUserDto> registerNewUser(@Valid RegistrationBodyDto registrationBodyDto);
    Mono<String> loginUser(@Valid UserLoginBodyDto body);
    Mono<String> generateNewRefreshToken(@Valid NewRefreshTokenBodyDto body);
}
