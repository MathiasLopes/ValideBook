package com.esi5.validebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
public class CommentaireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentaire;
    private Long idlivre;
    private Long iduser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Long getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Long idlivre) {
        this.idlivre = idlivre;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }
    
}
