package com.ecommerce.shopify.controller;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.model.entity.UserEntity;
import com.ecommerce.shopify.service.UsersService;
import com.ecommerce.shopify.utils.CommonUtils;
import com.ecommerce.shopify.utils.CreateRequestValidationUtil;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("shopify/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    CreateRequestValidationUtil requestValidationUtil;

    @Autowired
    CommonUtils commonUtils;

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllUsers() {
        List<UserEntity> userEntityList = null;
        try {
            userEntityList = usersService.getAllusers();
        } catch (Exception exception) {
            return new ResponseEntity<>("Exception occurred", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userEntityList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/getByEmail",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserByEmail(@RequestParam("email") String email) {

        Optional<UserEntity> userEntity = usersService.getUserByEmail(email);
        return new ResponseEntity<>(userEntity.get(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {

        UserEntity userEntity = null;
        List<String> errorList = requestValidationUtil.validateRequest(userDto);
        if (null == errorList || errorList.isEmpty()) {
            userEntity = usersService.createOrUpdateUser(userDto);
        } else {
            return new ResponseEntity<>(errorList, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userEntity, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {

        if (!commonUtils.isEmailExists(userDto)) {
            return new ResponseEntity<>("Invalid email address", new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = usersService.createOrUpdateUser(userDto);
        return new ResponseEntity<>(userEntity, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

}
