package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.entity.Message;

import javax.persistence.Id;

/**
 * Created by tanghe on 05/12/16.
 */
public abstract class SocialNetwork {
    @Id
    protected String id;

    public abstract void share(Message message);
}
