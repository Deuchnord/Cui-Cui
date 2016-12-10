package fr.tanghevandekadsye.jee.entity;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;
import fr.tanghevandekadsye.jee.SocialNetwork;
import fr.tanghevandekadsye.jee.exceptions.TryingToFollowMyselfException;
import fr.tanghevandekadsye.jee.exceptions.UserNotFollowedException;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentinvdk on 05/12/16.
 */
@Entity
public class User {
    @Id
    protected String id;
    protected String nom, photoUrl, password;
    protected String pseudo;
    protected List<User> followedUsers;
    protected List<SocialNetwork> socialNetworks;
    protected List<ContactInfo> contactInfos;
    protected String token;

    public User() {}

    public User(String nom, String pseudo, String mdp, String photoUrl, List<SocialNetwork> socialNetworks, List<ContactInfo> contactInfos,String token) {
        this.id = null;
        this.nom = nom;
        this.pseudo = pseudo;
        this.password = mdp;
        this.photoUrl = photoUrl;
        this.socialNetworks = socialNetworks;
        this.contactInfos = contactInfos;
        followedUsers = new ArrayList<>();
        this.token = token;
    }

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPseudo() { return pseudo; }
    public String getPhotoUrl() { return photoUrl; }
    public List<User> getFollowedUsers() { return followedUsers; }
    public List<SocialNetwork> getSocialNetworks() { return socialNetworks; }
    public List<ContactInfo> getContactInfos() { return contactInfos; }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setFollowedUsers(List<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public void addSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetworks.add(socialNetwork);
    }

    public void removeSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetworks.remove(socialNetwork);
    }

    public void removeSocialNetwork(int id) {
        this.socialNetworks.remove(id);
    }

    public void setContactInfos(List<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
    }

    public void addContactInfo(ContactInfo contactInfo) {
        this.contactInfos.add(contactInfo);
    }

    public void removeContactInfo(ContactInfo contactInfo) {
        this.contactInfos.remove(contactInfo);
    }

    public void removeContactInfo(int id) {
        this.contactInfos.remove(id);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void addFollowedUser(User user) throws TryingToFollowMyselfException {
        if(user.equals(this))
            throw new TryingToFollowMyselfException();

        this.followedUsers.add(user);
    }

    public void removeFollowedUser(User user) throws UserNotFollowedException {
        if(!followedUsers.contains(user))
            throw new UserNotFollowedException();
        followedUsers.remove(user);
    }
}
