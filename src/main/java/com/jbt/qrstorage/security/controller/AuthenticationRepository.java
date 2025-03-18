package com.jbt.qrstorage.security.controller;

import com.jbt.qrstorage.common.entity.AuthUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Repository
public class AuthenticationRepository implements IAuthenticationRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<AuthUser> registerNewUser(AuthUser user) {
        return reactiveMongoTemplate.save(user);
    }

    @Override
    public Mono<AuthUser> findUserByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where(AuthUser.Fields.email).is(email));

        return reactiveMongoTemplate.findOne(query, AuthUser.class);
    }

}
