package com.ip.bankmanager.validators;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<String> badResponse(String exceptionMessage) {
        JSONObject json = new JSONObject();
        json.put("message", exceptionMessage);
        return new ResponseEntity<String>(json.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
