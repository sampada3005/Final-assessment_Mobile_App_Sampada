package com.example.RestaurantWebApp.beans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> createResponse(String message, HttpStatus status, Object object){
        Map<String, Object> response = new HashMap<>();

        response.put("message", message);
        response.put("status", status);
        response.put("payload", object);

        return new ResponseEntity<>(response, status);
    }
}
