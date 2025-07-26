package com.codechallenge.auth.exeption;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.codechallenge.auth.resource.ApiResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHanler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResource<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiResource<Object> response = ApiResource.<Object>builder()
                .success(false)
                .message("Dữ liệu đầu vào không hợp lệ")
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .errors(errors)
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
