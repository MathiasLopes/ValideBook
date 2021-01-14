package com.esi5.validebook.controller;

import java.util.ArrayList;
import java.util.List;

import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.ForWebRequest.BookEntityRequest;
import com.esi5.validebook.repository.BookRepository;
//import com.google.gson.Gson;
import com.esi5.validebook.repository.LangueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRequestController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LangueRepository langueRepository;

    @GetMapping("/home/listebooks")
    public List<BookEntityRequest> listebook(){

        List<BookEntityRequest> listeBookComplet = new ArrayList<BookEntityRequest>();
        List<BookEntity> listeBook = bookRepository.findAll();

        for (var i = 0; i < listeBook.size(); i++){

            if(i < 20){
                BookEntity book = listeBook.get(i);

                BookEntityRequest bookComplet = new BookEntityRequest();

                //on recuepre directement toutes les informations dans l'objet
                bookComplet.setDateajout(book.getDateajout());
                bookComplet.setId(book.getId());
                bookComplet.setIdcategorie(book.getIdcategorie());
                bookComplet.setIdlangue(book.getIdlangue());
                bookComplet.setIduserajout(book.getIduserajout());
                bookComplet.setResume(book.getResume());
                bookComplet.setTitre(book.getTitre());

                //on recupere la langue dans la table langue avec son id
                bookComplet.setLangue(langueRepository.findById((long) book.getIdlangue()).get().getLangue());

                //ajout du livre dans la liste
                listeBookComplet.add(bookComplet);
            }else{
                break;
            }
        }

        return listeBookComplet; //bookRepository.findAll();
    }

}
