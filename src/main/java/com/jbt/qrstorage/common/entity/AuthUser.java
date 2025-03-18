package com.jbt.qrstorage.common.entity;

import com.jbt.qrstorage.common.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@FieldNameConstants
@Document("auth.auth-user")
public class AuthUser {

    @Id
    private ObjectId id;

    private String email;

    private String password;

    private List<Role> roles;

    @Transient
    public List<String> getRoleNames() {
        return this.roles.stream()
                .map(Enum::name)
                .toList();
    }

}
