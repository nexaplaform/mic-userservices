package com.fiverr.app.mic.userservices.domain;

import lombok.*;

@Data
@With
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;
    private String name;
    private String description;
    private Boolean active;
}
