package com.esi5.validebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.esi5.validebook.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    @Query(value="Select * from user", nativeQuery=true)
    List<UserEntity> getUsers();
    
}