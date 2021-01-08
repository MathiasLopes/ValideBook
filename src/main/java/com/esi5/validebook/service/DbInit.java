package com.esi5.validebook.service;

import com.esi5.validebook.entity.UserEntity;
import com.esi5.validebook.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();
        
        UserEntity user = new UserEntity();
        user.setEmail("sguerfi12@yahoo.com");
        user.setFirstName("TOTO");
        user.setLastName("TOTO");
        user.setAccountVerified(true);
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRoles("ADMIN");

        UserEntity user1 = new UserEntity();
        user1.setEmail("sguerfi12@gmail.com");
        user1.setFirstName("TITI");
        user1.setLastName("TITI");
        user1.setAccountVerified(true);
        user1.setPassword(passwordEncoder.encode("12345"));
        user1.setRoles("USER");

        UserEntity user2 = new UserEntity();
        user2.setEmail("mathias@test.fr");
        user2.setFirstName("Mathias");
        user2.setLastName("Lopes");
        user2.setAccountVerified(true);
        user2.setPassword(passwordEncoder.encode("1234"));
        user2.setRoles("ADMIN");
        
        List<UserEntity> liste = new ArrayList<>();
        liste.add(user);
        userRepository.saveAndFlush(user);
        liste.add(user1);
        userRepository.saveAndFlush(user1);
        liste.add(user2);
        userRepository.saveAndFlush(user2);
 
    }

}

