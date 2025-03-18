package com.jbt.qrstorage.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class AuthenticationRepository implements IAuthenticationRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

}
