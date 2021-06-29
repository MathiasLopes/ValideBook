package com.esi5.validebook.controller;

import java.util.ArrayList;
import java.util.List;

import com.esi5.validebook.entity.UserEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.esi5.validebook.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("/admin/users")
    public String adminusers(){
        return "admin/adminusers";
    }
    
    @GetMapping("/admin/listusers")
    public List<UserEntity> listeusers() {
        List<UserEntity> listUser = userRepository.getUsers();

        return listUser;
    }

}
