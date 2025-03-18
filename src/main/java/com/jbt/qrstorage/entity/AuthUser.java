package com.jbt.qrstorage.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.repository.Collection;

@Collection("auth.auth-user")
public class AuthUser {

    @Id
    private ObjectId id;

    private String email;

    private String password;

}
