package com.ecommerce.shopify.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
@Data
public class UserEntity {

    @Id
    private String id;

    private String email;

    private String firstName;

    private String lastName;

    private String dob;

    private String address;

    private boolean isActive;
}
