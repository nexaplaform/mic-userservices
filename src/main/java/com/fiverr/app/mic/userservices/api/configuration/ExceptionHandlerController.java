package com.fiverr.app.mic.userservices.api.configuration;

import com.fiverr.app.mic.userservices.api.service.dto.out.ErrorResponse;
import com.fiverr.app.mic.userservices.domain.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.List;

import static com.fiverr.app.mic.userservices.domain.error.Errors.JSON_FORMAT_ERROR;
import static com.fiverr.app.mic.userservices.domain.error.Errors.VALIDATION_ERROR;


@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundHandlerException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(List.of())
                .timeStamp(ZonedDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(JSON_FORMAT_ERROR.getCode())
                .message(JSON_FORMAT_ERROR.getMessage())
                .details(List.of())
                .timeStamp(ZonedDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return new ResponseEntity<>(ErrorResponse.builder()
                .code(VALIDATION_ERROR.getCode())
                .message(VALIDATION_ERROR.getMessage())
                .details(details)
                .timeStamp(ZonedDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
