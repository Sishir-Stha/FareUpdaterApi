package com.api.fareupdater.authentication.service;

import com.api.fareupdater.authentication.entity.UserEntity;
import com.api.fareupdater.authentication.mapper.AuthEntityToDto;
import com.api.fareupdater.authentication.repository.AuthRespository;
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
