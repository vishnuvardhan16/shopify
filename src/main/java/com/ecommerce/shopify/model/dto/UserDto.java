package com.ecommerce.shopify.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDto {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private boolean isActive;

}
