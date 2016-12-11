package fr.tanghevandekadsye.jee.controller.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;

import fr.tanghevandekadsye.jee.entity.User;
import fr.tanghevandekadsye.jee.exceptions.InvalidTokenException;
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

    @JsonIgnore
    public static String TOKEN_ACCEPTED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Permet à l'utilisateur d'obtenir un token pour l'api
     * @param username
     * @param password
     */
    @RequestMapping(value = "/obtainToken/{username}/{password}",method = RequestMethod.PUT)
    public void obtainToken(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password)
    {
        String token = generateToken();
        User user = userRepository.findByPseudoAndPassword(username,password);
        user.setToken(token);
        userRepository.save(user);
    }

    @RequestMapping(value = "/deleteToken/{username}/{password}/{token}",method = RequestMethod.DELETE)
    public void deleteToken(@PathVariable(value = "username")String username,@PathVariable(value = "password")String password,@PathVariable(value = "token")String token) throws InvalidTokenException {
        User user = userRepository.findByPseudoAndPasswordAndToken(username,password,token);

        if(user == null)
            throw new InvalidTokenException();

        user.setToken(null);
        userRepository.save(user);
    }

    /**
     * Génère une chaîne de 30 caractères à utiliser comme token.
     * @return le token généré
     */
    public static String generateToken() {
        return generateToken(30);
    }

    /**
     * Génère une chaîne contenant <code>nbChar</code> caractères à utiliser comme token.
     * @param nbChar la taille de la chaîne
     * @return le token généré
     */
    public static String generateToken(int nbChar) {
        return generateToken(nbChar, TOKEN_ACCEPTED_CHARACTERS);
    }

    /**
     * Génère une chaîne contenant <code>nbChar</code> caractères à utiliser comme token.
     * @param nbChar la taille de la chaîne
     * @param acceptedCharacters une chaîne contenant les caractères susceptibles de se trouver dans le token
     * @return le token généré
     */
    public static String generateToken(int nbChar, String acceptedCharacters) {
        String token = "";

        for(int i = 0; i < nbChar; i++)
            token += acceptedCharacters.charAt((int) (Math.random() * acceptedCharacters.length()));

        return token;
    }

    @RequestMapping("/get/{username}")
    public Iterable<User> getByPseudo(@PathVariable(value = "username") String pseudo)
    {
        return userRepository.findByPseudo(pseudo);
    }

    @RequestMapping(value = "/{username}/{newUsername}/{token}",method = RequestMethod.PUT)
    public void setPseudo(@PathVariable(value = "username") String pseudo,@PathVariable(value = "newUsername")String nouveauPseudo,@PathVariable(value = "token") String token) throws InvalidTokenException {
        User user =userRepository.findByPseudoAndToken(pseudo,token);

        if(user == null)
            throw new InvalidTokenException();

        user.setPseudo(nouveauPseudo);
        userRepository.save(user);
    }

    @RequestMapping("/{id}")
    public User findById(@PathVariable(value = "id") String id)
    {
        return userRepository.findOne(id);
    }

    @RequestMapping("/")
    public Iterable<User> findAll()
    {
        return userRepository.findAll();
    }


}
