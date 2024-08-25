package com.ecommerce.shopify.controller;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.model.entity.UserEntity;
import com.ecommerce.shopify.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shopify/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllUsers() {

        return null;
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {

        UserEntity userEntity = usersService.createUser(userDto);

        return new ResponseEntity<>(userEntity, new HttpHeaders(), HttpStatus.OK);
    }

}
