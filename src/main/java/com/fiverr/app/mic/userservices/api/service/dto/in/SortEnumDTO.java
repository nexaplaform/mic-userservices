package com.fiverr.app.mic.userservices.api.service.dto.in;

import lombok.Getter;

@Getter
public enum SortEnumDTO {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    SortEnumDTO(String value) {
        this.value = value;
    }
}
