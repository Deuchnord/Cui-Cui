package fr.tanghevandekadsye.jee.Interfaces.Repository;

import fr.tanghevandekadsye.jee.Entity.Message;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by quentinvdk on 05/12/16.
 */
public interface MessageRepository extends CrudRepository<Message,Long> {

    List<Message> findByHashtag(String hashtag);
    List<Message> findByText (String Text);

}
