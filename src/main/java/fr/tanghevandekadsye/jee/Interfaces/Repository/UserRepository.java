package fr.tanghevandekadsye.jee.Interfaces.Repository;

import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by quentinvdk on 05/12/16.
 */
public interface UserRepository  extends MongoRepository<User,String> {

    User findByToken(String token);
    User findByPseudoAndPassword(String pseudo, String password);
    User findByPseudoAndPasswordAndToken(String pseudo, String password,String token);
    List<User> findByPseudo(String pseudo);
    User findByPseudoAndToken(String pseudo, String token);
}
