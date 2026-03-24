package net.javaguides.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<?> handleAccountException(AccountException e, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                webRequest.getDescription(false),
                "ACCOUNT_NOT_FOUND");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                e.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
