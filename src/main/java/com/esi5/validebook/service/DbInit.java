package com.esi5.validebook.service;

import com.esi5.validebook.entity.UserEntity;
import com.esi5.validebook.repository.UserRepository;
import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.LangueEntity;
import com.esi5.validebook.repository.BookRepository;
import com.esi5.validebook.repository.LangueRepository;

import java.util.ArrayList;
import java.util.Date;
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
    BookRepository bookRepository;
    @Autowired
    LangueRepository langueRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    public void run(String... args) throws Exception {
        
        //insertion dans la table utilisateur
        resetAndInsertUsers();

        //insertion pour la tale book
        //resetAndInsertBooks();

        //ajoute les langues dans la base de données
        resetAndInsertLangues();
        
    }

    //Insertion pour la table utilisateur
    public void resetAndInsertUsers(){

        userRepository.deleteAll();
        
        UserEntity user = new UserEntity();
        user.setEmail("sguerfi12@yahoo.com");
        user.setNomComplet("TOTO");
        user.setAccountVerified(true);
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRoles("ADMIN");

        UserEntity user1 = new UserEntity();
        user1.setEmail("sguerfi12@gmail.com");
        user1.setNomComplet("TITI");
        user1.setAccountVerified(true);
        user1.setPassword(passwordEncoder.encode("12345"));
        user1.setRoles("USER");

        UserEntity user2 = new UserEntity();
        user2.setEmail("mathias@test.fr");
        user2.setNomComplet("Mathias Lopes");
        user2.setAccountVerified(true);
        user2.setPassword(passwordEncoder.encode("1234"));
        user2.setRoles("ADMIN");

        UserEntity user3 = new UserEntity();
        user3.setEmail("spec@test.fr");
        user3.setNomComplet("Specialiste");
        user3.setAccountVerified(true);
        user3.setPassword(passwordEncoder.encode("1234"));
        user3.setRoles("SPECIALISTE");
        
        List<UserEntity> listeuser = new ArrayList<>();
        listeuser.add(user);
        userRepository.saveAndFlush(user);
        listeuser.add(user1);
        userRepository.saveAndFlush(user1);
        listeuser.add(user2);
        userRepository.saveAndFlush(user2);
        listeuser.add(user3);
        userRepository.saveAndFlush(user3);

    }

    //insertion pour la tale books
    public void resetAndInsertBooks(){

        /*bookRepository.deleteAll();

        BookEntity book1 = new BookEntity();
        book1.setTitre("Lupin");
        book1.setIdlangue(1);
        book1.setMeilleurextrait("blablabla");
        book1.setResume("blobloblo");
        book1.setIduser(-1);
        book1.setIdcategorie(2);
        book1.setDateajout(new Date(System.currentTimeMillis()));
        
        BookEntity book2 = new BookEntity();
        book2.setTitre("Lupdeux");
        book2.setIdlangue(2);
        book2.setMeilleurextrait("bliblibli");
        book2.setResume("blyblybly");
        book2.setIduser(-1);
        book2.setIdcategorie(1);
        book2.setDateajout(new Date(System.currentTimeMillis()));
        
        List<BookEntity> listebook = new ArrayList<>();
        listebook.add(book1);
        bookRepository.saveAndFlush(book1);
        listebook.add(book2);
        bookRepository.saveAndFlush(book2);*/

    }

    //ajoute les langues dans la base de données
    public void resetAndInsertLangues(){

        langueRepository.deleteAll();

        LangueEntity langue1 = new LangueEntity();
        langue1.setId((long) 1);
        langue1.setLangue("Français");

        LangueEntity langue2 = new LangueEntity();
        langue2.setId((long) 2);
        langue2.setLangue("Anglais");

        LangueEntity langue3 = new LangueEntity();
        langue3.setId((long) 3);
        langue3.setLangue("Tamazight");

        LangueEntity langue4 = new LangueEntity();
        langue4.setId((long) 4);
        langue4.setLangue("Arabe");

        List<LangueEntity> listelangues = new ArrayList<>();
        listelangues.add(langue1);
        langueRepository.saveAndFlush(langue1);
        listelangues.add(langue2);
        langueRepository.saveAndFlush(langue2);
        listelangues.add(langue3);
        langueRepository.saveAndFlush(langue3);
        listelangues.add(langue4);
        langueRepository.saveAndFlush(langue4);

    }

}

