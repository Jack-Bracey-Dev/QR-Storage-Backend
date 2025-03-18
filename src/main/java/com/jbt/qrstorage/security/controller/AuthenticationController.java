package com.jbt.qrstorage.security.controller;

import com.jbt.qrstorage.security.dto.RegistrationBodyDto;
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

    private final AuthenticationService authenticationService;

    @PermitAll
    @PostMapping("login")
    public Mono<String> login() {
        return Mono.just("Logged in");
    }

    @PermitAll
    @PostMapping("logout")
    public Mono<String> logout() {
        return Mono.just("Logged out");
    }

    @PermitAll
    @PostMapping("register")
    public Mono<String> register(@Valid @RequestBody RegistrationBodyDto body) {
        return Mono.just("Welcome " + body.getEmail());
    }

    @PermitAll
    @PostMapping("refreshToken")
    public Mono<String> refreshToken() {
        return Mono.just("Refreshed token");
    }

}
