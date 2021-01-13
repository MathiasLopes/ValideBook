package com.esi5.validebook.entity;

import javax.persistence.*;

@Entity
@Table(name = "langues")
public class LangueEntity {
    
    @Id
    private Long id;
    private String langue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }


}
