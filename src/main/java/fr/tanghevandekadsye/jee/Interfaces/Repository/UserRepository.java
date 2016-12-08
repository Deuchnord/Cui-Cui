package fr.tanghevandekadsye.jee.Interfaces.Repository;

import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


/**
 * Created by quentinvdk on 05/12/16.
 */
public interface UserRepository  extends CrudRepository<User,Long> {

    User findByToken(String token);
    User findByPseudoAndPassword(String pseudo, String password);
    User findByPseudoAndPasswordAndToken(String pseudo, String password,String token);
    ArrayList<User> findByPseudo(String pseudo);
    User findByPseudoAndToken(String pseudo, String token);
}
