package com.jbt.qrstorage.security.controller;

import com.jbt.qrstorage.entity.AuthUser;
import reactor.core.publisher.Mono;

public interface IAuthenticationRepository {
    Mono<AuthUser> registerNewUser(AuthUser user);
    Mono<AuthUser> findUserByEmail(String email);
}
