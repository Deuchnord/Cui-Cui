package fr.tanghevandekadsye.jee.Interfaces.Repository;

import fr.tanghevandekadsye.jee.Entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by quentinvdk on 05/12/16.
 */
public interface UserRepository  extends CrudRepository<User,Long> {
}
