package fr.tanghevandekadsye.jee.Entity;

import org.springframework.data.annotation.Id;

/**
 * Created by quentinvdk on 05/12/16.
 */
public class User {
    @Id
    protected Long id;
    protected String nom, pseudo, photoUrl;

    public User() {}

    public User(String nom, String pseudo, String photoUrl) {
        this.nom = nom;
        this.pseudo = pseudo;
        this.photoUrl = photoUrl;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPseudo() { return pseudo; }
    public String getPhotoUrl() { return photoUrl; }
}
