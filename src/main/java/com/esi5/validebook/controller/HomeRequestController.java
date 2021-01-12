package com.esi5.validebook.controller;

import java.util.List;

import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.repository.BookRepository;
//import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRequestController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/home/listebooks")
    public List<BookEntity> listebook(){
        return bookRepository.findAll();
    }

}
