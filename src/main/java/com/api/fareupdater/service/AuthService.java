package com.api.fareupdater.service;

import com.api.fareupdater.dto.response.LoginResponse;
import com.api.fareupdater.entity.UserEntity;
import com.api.fareupdater.mapper.AuthEntityToDto;
import com.api.fareupdater.repository.AuthRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRespository respository;

    @Autowired
    private AuthEntityToDto mapper;

    public UserEntity login (String username , String password){
        UserEntity user = respository.userbylogon(username,password);
        if (user != null){
            return user;
        }else {
            return null;
        }
    }
}
