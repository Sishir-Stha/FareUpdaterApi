package com.api.fareupdater.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.PhantomReference;

@Data
@AllArgsConstructor
public class LoginResponse {
    private int status;
    private String token;
    private String username;
    private String userCode;
}
