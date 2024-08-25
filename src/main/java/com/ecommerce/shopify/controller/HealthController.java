package com.ecommerce.shopify.controller;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getHealthStatus() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "ok");
        return new ResponseEntity<>(jsonObject.toString(), new HttpHeaders(), HttpStatus.OK);
    }
}
