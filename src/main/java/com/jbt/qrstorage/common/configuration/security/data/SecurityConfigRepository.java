package com.jbt.qrstorage.common.configuration.security.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class SecurityConfigRepository implements ISecurityConfigRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

}
