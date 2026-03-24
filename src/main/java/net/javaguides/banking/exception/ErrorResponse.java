package net.javaguides.banking.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public record ErrorResponse(
        LocalDateTime timestamp,
        String message,
        String details,
        String errorCode
) {
}
