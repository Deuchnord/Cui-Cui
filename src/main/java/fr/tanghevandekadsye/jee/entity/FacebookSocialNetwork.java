package fr.tanghevandekadsye.jee.entity;

import fr.tanghevandekadsye.jee.SocialNetwork;

import javax.persistence.Entity;

/**
 * Created by jerome on 10/12/16.
 */
@Entity
public class FacebookSocialNetwork extends SocialNetwork {
    @Override
    public void share(Message message) {

    }
}
