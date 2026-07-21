package com.lifeline.exception;

import com.lifeline.dto.AuthResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public AuthResponseDTO handleResourceAlreadyExists(ResourceAlreadyExistsException ex) {
        return new AuthResponseDTO(null, ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public AuthResponseDTO handleRuntimeException(RuntimeException ex) {
        return new AuthResponseDTO(null, ex.getMessage());
    }
}