package fr.tanghevandekadsye.jee.controller.html;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import fr.tanghevandekadsye.jee.SocialNetwork;
import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerome on 10/12/16.
 */

@Controller
public class UserHtmlController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/subscribe")
    public String createUser() {
        return "subscribe";
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public String createUser(String nom, String pseudo, String mdp, String photoUrl, List<SocialNetwork> socialNetworks, List<ContactInfo> contactInfos) {
        User newUser = new User(nom, pseudo, mdp, photoUrl, socialNetworks, contactInfos, null);
        userRepository.save(newUser);

        return "subscribe_success";
    }

    @RequestMapping(value = "/edit_profile")
    public String editUser() {
        return "edit_profile";
    }

    @RequestMapping(value = "/edit-profile", method = RequestMethod.POST)
    public String editUser(User user) {
        userRepository.save(user);

        return "edit_profile_success";
    }

    @RequestMapping("/search/users")
    public String searchUsers(Model model, @RequestParam String keywords) {
        List<User> foundUsers = new ArrayList<>();

        List<User> usersFoundByPseudo = userRepository.findByPseudo(keywords);
        List<User> usersFoundByName = userRepository.findByPseudo(keywords);

        foundUsers.addAll(usersFoundByPseudo);
        foundUsers.addAll(usersFoundByName);

        return "search_users";
    }
}
