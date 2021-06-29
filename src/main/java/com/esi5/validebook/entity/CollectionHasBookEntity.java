package com.esi5.validebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "collectionhasbook")
public class CollectionHasBookEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idcollection;
    private Long idlivre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcollection() {
        return idcollection;
    }

    public void setIdcollection(Long idcollection) {
        this.idcollection = idcollection;
    }

    public Long getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Long idlivre) {
        this.idlivre = idlivre;
    }
}
