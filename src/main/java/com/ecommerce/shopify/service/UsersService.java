package com.ecommerce.shopify.service;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.model.entity.UserEntity;
import com.ecommerce.shopify.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoRepository mongoRepository;

    public UserEntity createUser(UserDto userDto) {

        if (userDto != null) {
            UserEntity userEntity = userDtoToEntity(userDto);
            UserEntity dbResult = write(userEntity);
            return dbResult;
        }
        return null;
    }

    private UserEntity userDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setDob(userDto.getDob());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userEntity.getLastName());
        userEntity.setAddress(userEntity.getAddress());
        return userEntity;
    }

    private UserEntity write(UserEntity userEntity) {
        log.info("Writing to DB");
        UserEntity userEntity1 = userRepository.save(userEntity);
        log.info("DB write successful");
        return userEntity1;
    }

}


