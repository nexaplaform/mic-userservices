package com.fiverr.app.mic.userservices.domain;

import lombok.*;

import java.util.List;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    @Builder.Default
    private Boolean active = true;
    private List<Role> roles;
}
