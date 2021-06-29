package com.esi5.validebook.entity.ForWebRequest;

public class FilterBookEntityRequest {
    
    private String titre;
    private String langue;
    private String datepublication;
    private String theme;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(String datepublication) {
        this.datepublication = datepublication;
    }

    //ne pas utiliser si le champ datepublication est null !
    public String getDatepublicationdebut(){
        return datepublication + " 00:00:00";
    }

    //ne pas utiliser si le champ datepublication est null !
    public String getDatepublicationfin(){
        return datepublication + " 23:59:59";
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
