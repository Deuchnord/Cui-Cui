package fr.tanghevandekadsye.jee.controller.rest;

import fr.tanghevandekadsye.jee.Interfaces.Repository.MessageRepository;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import fr.tanghevandekadsye.jee.entity.Message;
import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quentinvdk on 05/12/16.
 * Api rest des messages
 */

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageRepository repository;

    @Autowired
    private UserRepository userRepo;

    /**
     * Obtenir un message par son id
     * @param id l'id du message
     * @return Le message
     */
    @RequestMapping("/{id}")
    public Message getMessage(@PathVariable(value = "id") long id)
    {
        return repository.findOne(id);
    }

    @RequestMapping("/")
    public Iterable<Message> getAll()
    {
        return repository.findAll();
    }

    @RequestMapping("/hashtag/{name}")
    public Iterable<Message> getByHashtags(@PathVariable(value = "name") String hashtag)
    {
        return repository.findByHashtag(hashtag);
    }

    @RequestMapping("/search/{text}")
    public Iterable<Message> getByText(@PathVariable(value = "text") String text)
    {
        return repository.findByText(text);
    }
    /*
    Méthodes POST
     */

    @RequestMapping(value = "/{token}/{message}",method = RequestMethod.POST)
    public void addMessage(@PathVariable(value = "token") String token, @PathVariable(value = "message") String message)
    {
        User author = userRepo.findByToken(token);
        Message msg = new Message(author, message);
        repository.save(msg);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMessage(@PathVariable(value = "id") long id)
    {
        repository.delete(id);
}



}
