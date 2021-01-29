package com.esi5.validebook.controller;

import java.util.ArrayList;
import java.util.List;

import com.esi5.validebook.entity.ArticleEntity;
import com.esi5.validebook.entity.AuteurEntity;
import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.BookHasAuteurEntity;
import com.esi5.validebook.entity.CollectionEntity;
import com.esi5.validebook.entity.CollectionHasBookEntity;
import com.esi5.validebook.entity.CommentaireEntity;
import com.esi5.validebook.entity.EditeurEntity;
import com.esi5.validebook.entity.EditeurHasBookEntity;
import com.esi5.validebook.entity.ExtraitEntity;
import com.esi5.validebook.entity.LangueEntity;
import com.esi5.validebook.entity.ForWebRequest.BookEntityRequest;
import com.esi5.validebook.entity.ForWebRequest.FilterBookEntityRequest;
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
public class HomeRequestController {

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
    ArticleRepository articleRepository;
    @Autowired
    BookHasAuteurRepository bookHasAuteurRepository;
    @Autowired
    AuteurRepository auteurRepository;
    @Autowired
    CollectionHasBookRepository collectionHasBookRepository;
    @Autowired
    CollectionRepository collectionRepository;
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    EditeurHasBookRepository editeurHasBookRepository;
    @Autowired
    EditeurRepository editeurRepository;
    

    @GetMapping("/home/listebooks")
    public List<BookEntityRequest> listebook(){

        List<BookEntityRequest> listeBookComplet = new ArrayList<BookEntityRequest>();
        //List<BookEntity> listeBook = bookRepository.findAll();

        List<BookEntity> listeBook = bookRepository.getXLastBookValidate(20);

        try{

            for (var i = 0; i < listeBook.size(); i++){

                BookEntity book = listeBook.get(i);

                //si i est plus petit que 20 et que l'id user valide est plus grand que 0 (il y a donc bien été validé)
                if(i < 20 && book.isValidee()){

                    //on recupere toutes les infos d'un book
                    BookEntityRequest bookComplet = getBookComplet(book);

                    //ajout du livre dans la liste
                    listeBookComplet.add(bookComplet);

                }else{
                    break;
                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return listeBookComplet;
    }

    @PostMapping(value = "/home/search", consumes = "application/json", produces = "application/json")
    public List<BookEntityRequest> getBookWithFilter(@RequestBody FilterBookEntityRequest filters){
        
        List<BookEntity> listBooks = recuperationListBooksEnFonctionDeTousLesCas(filters);

        List<BookEntityRequest> listBooksComplete = new ArrayList<BookEntityRequest>();
        for (BookEntity book : listBooks) {
            listBooksComplete.add(getBookComplet(book));
        }

        return listBooksComplete;
    }

    public enum FiltersSearched {
        titre(1),
        langue(2);

        private final Integer id;
         /*
        * @param rank should be byte
        */
        private FiltersSearched(Integer id)
        {
            this.id=id;
        }
    }

    private List<BookEntity> recuperationListBooksEnFonctionDeTousLesCas(FilterBookEntityRequest filters){

        int filtersSearched = 0;

        Boolean titreSearched = false;
        if(filters.getTitre() != null){
            filtersSearched += FiltersSearched.titre.id;
        }

        Boolean langueSearched = false;
        if(filters.getLangue() != null){
            filtersSearched += FiltersSearched.langue.id;
        }

        List<BookEntity> listBooks = new ArrayList<BookEntity>();

        //attention, ici est un filtre grace au byte
        if(filtersSearched == 1){ //filtre titre uniquement
            listBooks = bookRepository.getWithTitre("%" + filters.getTitre() + "%");
        }else if(filtersSearched == 2){ //filtre langue uniquement
            listBooks = bookRepository.getWithLangue("%" + filters.getLangue() + "%");
        }else if(filtersSearched == 3){ //filtre titre + langue
            listBooks = bookRepository.getWithTitreAndLangue("%" + filters.getTitre() + "%", "%" + filters.getLangue() + "%");
        }

        return listBooks;
    }

    private BookEntityRequest getBookComplet(BookEntity book){

        BookEntityRequest bookComplet = new BookEntityRequest();

        //on recuepre directement toutes les informations dans l'objet
        bookComplet.setDateajout(book.getDateajout());

        //on set tous les champs ID
        bookComplet.setId(book.getId());
        bookComplet.setIdcategorie(book.getIdcategorie());
        bookComplet.setIdlangue(book.getIdlangue());
        bookComplet.setIduserajout(book.getIduserajout());
        bookComplet.setIdgenre(book.getIdgenre());
        bookComplet.setIduservalide(book.getIduservalide());

        //on set tous les champs dates
        bookComplet.setDateajout(book.getDateajout());
        bookComplet.setDatepublication(book.getDatepublication());
        bookComplet.setDatevalidation(book.getDatevalidation());
        
        //on set tous les champs textes
        bookComplet.setResume(book.getResume());
        bookComplet.setTitre(book.getTitre());
        bookComplet.setMotcles(book.getMotcles());

        //on set toutes les listes et champ venant d'autres tables
        bookComplet.setLangue(langueRepository.findById((long) book.getIdlangue()).get());
        bookComplet.setCategorie(categorieRepository.findById((long) book.getIdcategorie()).get());
        bookComplet.setGenre(genreRepository.findById((long) book.getIdgenre()).get());

        //on met des try catch au cas ou il y a une erreur lors de la requete
        //extraits
        List<ExtraitEntity> listExtrait = new ArrayList<>();
        try{
            listExtrait = extraitRepository.findByIdlivre(book.getId());
        }catch(Exception e){ }

        bookComplet.setListExtraits(listExtrait);

        //articles
        List<ArticleEntity> listArticle = new ArrayList<>();
        try{
            listArticle = articleRepository.findByIdlivre(book.getId());
        }catch(Exception e){ }
        bookComplet.setListArticles(listArticle);

        //auteurs
        List<AuteurEntity> listAuteurs = getListAuteurs(book.getId());
        bookComplet.setListAuteurs(listAuteurs);
        
        //collections
        List<CollectionEntity> listCollection = getListCollections(book.getId());
        bookComplet.setListCollections(listCollection);

        //commentaires
        List<CommentaireEntity> listCommentaires = new ArrayList<>();
        try{
            listCommentaires = commentaireRepository.findByIdlivre(book.getId());
        }catch(Exception e){ }
        bookComplet.setListCommentaires(listCommentaires);

        //editeurs
        List<EditeurEntity> listEditeurs = getListEditeurs(book.getId());
        bookComplet.setListEditeurs(listEditeurs);

        return bookComplet;

    }

    private List<EditeurEntity> getListEditeurs(long idbook){

        List<EditeurEntity> listEditeurs = new ArrayList<>();
        List<EditeurHasBookEntity> listEditeurHasBook = new ArrayList<>();
        try{
            listEditeurHasBook = editeurHasBookRepository.findByIdlivre(idbook);
        }catch(Exception e){ }
        
        //s'il y a bien des auteurs pour ce livre
        if(listEditeurHasBook.size() > 0){
            for (EditeurHasBookEntity editeurHasBookEntity : listEditeurHasBook) {
                try{
                    //on ajoute les auteurs
                     listEditeurs.add(editeurRepository.findById(editeurHasBookEntity.getIdediteur()).get());
                }catch(Exception e){ }
            }
        } 

        return listEditeurs;
    }

    private List<CollectionEntity> getListCollections(long idbook){

        List<CollectionEntity> listCollection = new ArrayList<>();
        List<CollectionHasBookEntity> listCollectionHasBook = new ArrayList<>();
        try{
            listCollectionHasBook = collectionHasBookRepository.findByIdlivre(idbook);
        }catch(Exception e){ }
        
        //s'il y a bien des auteurs pour ce livre
        if(listCollectionHasBook.size() > 0){
            for (CollectionHasBookEntity collectionHasBookEntity : listCollectionHasBook) {
                try{
                    //on ajoute les auteurs
                     listCollection.add(collectionRepository.findById(collectionHasBookEntity.getIdcollection()).get());
                }catch(Exception e){ }
            }
        } 

        return listCollection;

    }

    private List<AuteurEntity> getListAuteurs(long idbook){
        List<AuteurEntity> listAuteur = new ArrayList<>();
        List<BookHasAuteurEntity> listBookHasAuteur = new ArrayList<>();
        try{
            listBookHasAuteur = bookHasAuteurRepository.findByIdlivre(idbook);
        }catch(Exception e){ }
        
        //s'il y a bien des auteurs pour ce livre
        if(listBookHasAuteur.size() > 0){
            for (BookHasAuteurEntity bookHasAuteurEntity : listBookHasAuteur) {
                try{
                    //on ajoute les auteurs
                     listAuteur.add(auteurRepository.findById(bookHasAuteurEntity.getIdauteur()).get());
                }catch(Exception e){ }
            }
        } 

        return listAuteur;
    }

}
