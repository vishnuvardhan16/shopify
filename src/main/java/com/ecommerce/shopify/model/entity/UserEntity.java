package com.ecommerce.shopify.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersEntity")
@Data
public class UserEntity {

    private String id;

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String dob;

    private String address;

    private boolean isActive;
}
