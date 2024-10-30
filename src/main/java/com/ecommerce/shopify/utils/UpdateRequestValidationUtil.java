package com.ecommerce.shopify.utils;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateRequestValidationUtil {

    @Autowired
    UserRepository userRepository;

    public void validate(UserDto userDto) {

    }
}
