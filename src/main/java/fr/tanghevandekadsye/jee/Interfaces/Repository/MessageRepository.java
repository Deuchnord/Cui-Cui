package fr.tanghevandekadsye.jee.Interfaces.Repository;

import fr.tanghevandekadsye.jee.Entity.Message;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by quentinvdk on 05/12/16.
 */
public interface MessageRepository extends CrudRepository<Message,Long> {
}
