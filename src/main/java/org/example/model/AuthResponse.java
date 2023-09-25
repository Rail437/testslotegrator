package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthResponse {
    private UserInfo user;
    private String accessToken;

    public AuthResponse() {
    }
}
