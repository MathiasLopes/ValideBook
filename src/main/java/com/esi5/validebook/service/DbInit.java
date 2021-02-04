package com.esi5.validebook.service;

import com.esi5.validebook.entity.UserEntity;
import com.esi5.validebook.repository.UserRepository;
import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.CategorieEntity;
import com.esi5.validebook.entity.ExtraitEntity;
import com.esi5.validebook.entity.GenreEntity;
import com.esi5.validebook.entity.LangueEntity;
import com.esi5.validebook.entity.ThemeEntity;
import com.esi5.validebook.repository.BookRepository;
import com.esi5.validebook.repository.CategorieRepository;
import com.esi5.validebook.repository.ExtraitRepository;
import com.esi5.validebook.repository.GenreRepository;
import com.esi5.validebook.repository.LangueRepository;
import com.esi5.validebook.repository.ThemeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    CategorieRepository categorieRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    ExtraitRepository extraitRepository;
    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Override
    public void run(String... args) throws Exception {
        
        //insertion dans la table utilisateur
        resetAndInsertUsers();

        //ajoute les langues dans la base de données
        resetAndInsertLangues();

        //insertion des categories de test
        resetAndInsertCategories();

        //insertion des genres de test
        resetAndInsertGenre();

        //insertion pour la tale book (livre de tests)
        resetAndInsertBooks();

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

    //insertion pour la table books
    public void resetAndInsertBooks(){

        bookRepository.deleteAll();
        resetExtraits();

        for (Integer i = 1; i < 25; i++){

            Random rand = new Random();

            BookEntity unBook = new BookEntity();
            unBook.setDateajout(new Date());
            unBook.setDatepublication(new Date());
            unBook.setDatevalidation(new Date());
            unBook.setIdcategorie(rand.nextInt(3 - 1 + 1) + 1);
            unBook.setIdtheme(1);
            unBook.setIdgenre(rand.nextInt(3 - 1 + 1) + 1);
            unBook.setIdlangue(rand.nextInt(4 - 1 + 1) + 1);
            unBook.setIduserajout(i);
            unBook.setIduservalide(i);
            unBook.setMotcles("test" + Integer.toString(i));
            unBook.setResume("je suis un résumé" + Integer.toString(i));
            unBook.setTitre("Livre" + Integer.toString(i));

            unBook = bookRepository.saveAndFlush(unBook);
            insertExtraits(unBook.getId());
        } 

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

    //ajout de categorie
    public void resetAndInsertCategories(){

        categorieRepository.deleteAll();

        CategorieEntity categorie1 = new CategorieEntity();
        categorie1.setId((long) 1);
        categorie1.setNom("Categorie 1");

        CategorieEntity categorie2 = new CategorieEntity();
        categorie2.setId((long) 2);
        categorie2.setNom("Categorie 2");

        CategorieEntity categorie3 = new CategorieEntity();
        categorie3.setId((long) 3);
        categorie3.setNom("Categorie 3");

        categorieRepository.saveAndFlush(categorie1);
        categorieRepository.saveAndFlush(categorie2);
        categorieRepository.saveAndFlush(categorie3);
    }

    //ajout de genre
    public void resetAndInsertGenre(){

        genreRepository.deleteAll();

        GenreEntity genre1 = new GenreEntity();
        genre1.setId((long) 1);
        genre1.setNom("Genre 1");

        GenreEntity genre2 = new GenreEntity();
        genre2.setId((long) 2);
        genre2.setNom("Genre 2");

        GenreEntity genre3 = new GenreEntity();
        genre3.setId((long) 3);
        genre3.setNom("Genre 3");

        genreRepository.saveAndFlush(genre1);
        genreRepository.saveAndFlush(genre2);
        genreRepository.saveAndFlush(genre3);

    }

    //permet d'effacer toutes les entrés de la table Extraits
    public void resetExtraits(){
        extraitRepository.deleteAll();
    }

    //permet d'insérer des extraits avec l'id du livre passé en paramètres
    public void insertExtraits(long idbook){
        ExtraitEntity unExtrait = new ExtraitEntity();
        unExtrait.setIdlivre(idbook);
        unExtrait.setExtrait("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        extraitRepository.saveAndFlush(unExtrait);
    }

    //Insertion pour la table utilisateur
    public void resetAndInsertTheme(){

        ThemeRepository.deleteAll();
        
        ThemeEntity theme1 = new ThemeEntity();
        theme1.setNom("Littérature");

        ThemeEntity theme2 = new ThemeEntity();
        theme2.setNom("Arthropologie et sciences du langage");

        ThemeEntity theme3 = new ThemeEntity();
        theme3.setNom("Arthropologie et sciences du langage");

        ThemeEntity theme4 = new ThemeEntity();
        theme4.setNom("Histoire");

        ThemeEntity theme5 = new ThemeEntity();
        theme5.setNom("Philosophie, Sociologie");

        ThemeEntity theme6 = new ThemeEntity();
        theme6.setNom("Revue, article, scientifique");

        ThemeEntity theme7 = new ThemeEntity();
        theme7.setNom("Sciences Politiques");

        ThemeEntity theme8 = new ThemeEntity();
        theme8.setNom("Citations");

        ThemeEntity theme9 = new ThemeEntity();
        theme9.setNom("Proverbe");
        
        ThemeEntity theme10 = new ThemeEntity();
        theme10.setNom("Adages");
        
        ThemeEntity theme11 = new ThemeEntity();
        theme11.setNom("Dictons"); 

    }

}

