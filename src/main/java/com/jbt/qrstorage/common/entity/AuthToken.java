package com.jbt.qrstorage.common.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@FieldNameConstants
@Document("auth.auth-refresh-token")
public class AuthToken {

    @Id
    private ObjectId id;

    private String token;

}
