package fr.tanghevandekadsye.jee.controller.rest;

import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/{token}")

}
