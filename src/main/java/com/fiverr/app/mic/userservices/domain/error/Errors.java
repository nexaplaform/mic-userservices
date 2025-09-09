package com.fiverr.app.mic.userservices.domain.error;

import lombok.Getter;

@Getter
public enum Errors {

    NOT_FOUND_RECORD("ENFD001", "El registro con id %s, no existe."),
    VALIDATION_ERROR("RQST001", "Las siguientes propiedades son requeridas."),
    JSON_FORMAT_ERROR("FRMT001", "El json de la petición esta mal formado.");

    private final String code;
    private final String message;

    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
