package com.jbt.qrstorage.security.controller;

import com.jbt.qrstorage.common.dto.AuthUserDto;
import com.jbt.qrstorage.security.dto.NewRefreshTokenBodyDto;
import com.jbt.qrstorage.security.dto.RegistrationBodyDto;
import com.jbt.qrstorage.security.dto.UserLoginBodyDto;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("auth")
@RestController
public class AuthenticationController {

    private final IAuthenticationService authenticationService;

    @PermitAll
    @PostMapping("login")
    public Mono<String> login(@Valid @RequestBody UserLoginBodyDto body) {
        return authenticationService.loginUser(body);
    }

    @PermitAll
    @PostMapping("logout")
    public Mono<String> logout() {
        return Mono.just("Logged out");
    }

    @PermitAll
    @PostMapping("register")
    public Mono<AuthUserDto> register(@Valid @RequestBody RegistrationBodyDto body) {
        return authenticationService.registerNewUser(body);
    }

    @PermitAll
    @PostMapping("refreshToken")
    public Mono<String> refreshToken(@Valid @RequestBody NewRefreshTokenBodyDto body) {
        return authenticationService.generateNewRefreshToken(body);
    }

}
