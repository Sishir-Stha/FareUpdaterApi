package com.api.fareupdater.authentication.repository;

import com.api.fareupdater.authentication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRespository  extends JpaRepository<UserEntity , String> {

    @Query(value = "EXEC uspGetAvantikUserAccount :username,:password", nativeQuery = true)
    UserEntity userbylogon(String username, String password);

}
