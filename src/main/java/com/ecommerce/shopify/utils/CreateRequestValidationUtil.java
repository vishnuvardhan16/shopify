package com.ecommerce.shopify.utils;

import com.ecommerce.shopify.model.dto.UserDto;
import com.ecommerce.shopify.model.entity.UserEntity;
import com.ecommerce.shopify.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateRequestValidationUtil {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommonUtils commonUtils;

    List<String> errorList = null;

    public List<String> validateRequest(UserDto userDto) {
        errorList = new ArrayList<>(2);

        if (commonUtils.isEmailExists(userDto)) {
            errorList.add("user email address already exists");
        }

        validateUserName(userDto);
        return errorList;
    }

    private void validateUserName(UserDto userDto) {
        if (userDto.getFirstName() == null || userDto.getFirstName().isBlank()) {
            errorList.add("Invalid first name");
        }
        if (userDto.getLastName() == null || userDto.getLastName().isBlank()) {
            errorList.add("Invalid last name");
        }
    }

    private JSONObject getErrorJsonObject(String key, String value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        return jsonObject;
    }
}
