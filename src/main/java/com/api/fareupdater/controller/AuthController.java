package com.api.fareupdater.controller;

import com.api.fareupdater.common.constants.ApiConstants;
import com.api.fareupdater.common.constants.HttpConstants;
import com.api.fareupdater.common.security.JwtTokenUtil;
import com.api.fareupdater.common.utils.ErrorMessage;
import com.api.fareupdater.dto.request.LoginRequest;
import com.api.fareupdater.dto.response.LoginResponse;
import com.api.fareupdater.entity.UserEntity;
import com.api.fareupdater.service.AuthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.AUTH_BASE)
public class AuthController {

    @Autowired
    public AuthService service;

    @PostMapping("/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginRequest request){
        try {
            UserEntity reponse = service.login(request.getUsername(), request.getPassword());
            if (reponse != null){
                log.info("<<Auth logging Request recieved>>");
                String token = JwtTokenUtil.generateToken(reponse.getUserId());
                return ResponseEntity.ok(new LoginResponse(200,token, reponse.getUsername(), reponse.getUserCode()));
            }else{
                log.debug("User is null ( Invalid user or credentials )");
                return ResponseEntity.status(HttpConstants.INVALID_CREDENTIALS).body(new ErrorMessage(401,"Invalid Credentials"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getUsername(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(401,"Server Error "));
        }
    }
}
