package com.api.fareupdater.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
@Data
public class UserEntity {

    @Id
    @Column(name = "user_logon")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_account_id")
    private String userId;

    @Column(name = "user_code")
    private String userCode;

}
