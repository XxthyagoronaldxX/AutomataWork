package com.tajad.automata_work.api.handles;

import com.tajad.automata_work.domain.exceptions.InvalidArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<?> invalidArgumentExceptionHandler(InvalidArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildApiException(exception));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildApiException(exception));
    }

    private ApiException buildApiException(Exception exception) {
        return ApiException.builder()
                .time(LocalDateTime.now())
                .message(exception.getMessage())
                .build();
    }
}
