package com.fiverr.app.mic.userservices.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException {

    private String code;
    private String message;
    private List<String> details;
    private ZonedDateTime timeStamp;

    public BaseException(String code, String message, ZonedDateTime timeStamp) {
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, List<String> details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
