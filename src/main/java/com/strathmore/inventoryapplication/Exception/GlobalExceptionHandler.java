package com.strathmore.inventoryapplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Map<String, String> resourceNotFound(ResourceNotFoundException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("error", exception.getMessage());
        map.put("code", "404");
        map.put("timestamp", LocalDateTime.now().toString());
        return map;
    }

}
