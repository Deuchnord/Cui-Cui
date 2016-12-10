package fr.tanghevandekadsye.jee.Interfaces.Repository;

import fr.tanghevandekadsye.jee.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Created by quentinvdk on 05/12/16.
 */
public interface MessageRepository extends MongoRepository<Message,String> {

    List<Message> findByHashtags(String hashtags);
    List<Message> findByText (String Text);

}
