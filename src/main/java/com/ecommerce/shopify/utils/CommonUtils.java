package com.ecommerce.shopify.utils;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.model.entity.UserEntity;
import com.ecommerce.shopify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommonUtils {
    
    @Autowired
    UserRepository userRepository;
    
    public boolean isEmailExists(UserDto userDto) {
        Optional<UserEntity> userEntity = userRepository.findById(userDto.getEmail());
        if (userEntity.isPresent()) {
            return true;
        }
        return false;
    }
}
