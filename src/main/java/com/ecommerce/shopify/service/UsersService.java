package com.ecommerce.shopify.service;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.model.entity.UserEntity;
import com.ecommerce.shopify.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoRepository mongoRepository;

    public UserEntity createOrUpdateUser(UserDto userDto) {

        if (userDto != null) {
            UserEntity userEntity = userDtoToEntity(userDto);
            UserEntity dbResult = write(userEntity);
            return dbResult;
        }
        return null;
    }

    public List<UserEntity> getAllusers() throws Exception {

        try {
            return userRepository.findAll();
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw exception;
        }
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findById(email);
    }

    private UserEntity userDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setDob(userDto.getDob());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setActive(userDto.isActive());
        return userEntity;
    }

    private UserEntity write(UserEntity userEntity) {
        log.info("Writing to DB");
        UserEntity userEntity1 = userRepository.save(userEntity);
        log.info("DB write successful");
        return userEntity1;
    }

}


