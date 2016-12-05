package fr.tanghevandekadsye.jee;

import fr.tanghevandekadsye.jee.entity.Message;

/**
 * Created by tanghe on 05/12/16.
 */
public abstract class SocialNetwork {
    protected Long id;

    public abstract void share(Message message);
}
