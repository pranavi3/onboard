package com.nav.onboard.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NonNull
    private String email;
    @NonNull
    private String password;
}
