package com.esi5.validebook.service;

import com.esi5.validebook.entity.UserEntity;
import com.esi5.validebook.repository.UserRepository;
import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.repository.BookRepository;

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
    BookRepository bookRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    public void run(String... args) throws Exception {
        
        //Insertion pour la table utilisateur
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

        UserEntity user3 = new UserEntity();
        user3.setEmail("spec@test.fr");
        user3.setFirstName("Specialiste");
        user3.setLastName("Pro");
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

        //insertion pour la tale books
        bookRepository.deleteAll();

        BookEntity book1 = new BookEntity();
        book1.setTitre("Lupin");
        book1.setLangue("Francais");

        BookEntity book2 = new BookEntity();
        book2.setTitre("Lupdeux");
        book2.setLangue("Anglais");
        
        List<BookEntity> listebook = new ArrayList<>();
        listebook.add(book1);
        bookRepository.saveAndFlush(book1);
        listebook.add(book2);
        bookRepository.saveAndFlush(book2);
    }

}

