package fr.tanghevandekadsye.jee.controller.rest;

import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;

import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quentinvdk on 06/12/16.
 * Api rest pour l'User
 */

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Permet à l'utilisateur d'obtenir un token pour l'api
     * @param username
     * @param password
     */
    @RequestMapping(value = "/obtainToken/{username}/{password}",method = RequestMethod.POST)
    public void obtainToken(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password)
    {
        User user = userRepository.findByPseudoAndPassword(username,password);
        //user.setToken(token);
        userRepository.save(user);
    }

    @RequestMapping(value = "/deleteToken/{username}/{password}/{token}",method = RequestMethod.DELETE)
    public void deleteToken(@PathVariable(value = "username")String username,@PathVariable(value = "password")String password,@PathVariable(value = "token")String token)
    {
        User user = userRepository.findByPseudoAndPasswordAndToken(username,password,token);
        user.setToken(null);
        userRepository.save(user);
    }

    @RequestMapping("/{username}")
    public Iterable<User> getByPseudo(@PathVariable(value = "username") String pseudo)
    {
        return userRepository.findByPseudo(pseudo);
    }

    @RequestMapping(value = "/{username}/{newUsername}/{token}",method = RequestMethod.PUT)
    public void setPseudo(@PathVariable(value = "username") String pseudo,@PathVariable(value = "newUsername")String nouveauPseudo,@PathVariable(value = "token") String token)
    {
        User user =userRepository.findByPseudoAndToken(pseudo,token);
        user.setPseudo(nouveauPseudo);
        userRepository.save(user);
    }

    @RequestMapping("/{id}")
    public User findById(@PathVariable(value = "id") long id)
    {
        return userRepository.findOne(id);
    }


}
