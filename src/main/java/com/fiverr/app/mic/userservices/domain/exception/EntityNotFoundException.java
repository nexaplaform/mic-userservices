package com.fiverr.app.mic.userservices.domain.exception;

import java.util.List;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(String code, String message) {
        super(code, message);
    }

    public EntityNotFoundException(String code, String message, List<String> details) {
        super(code, message, details);
    }
}
