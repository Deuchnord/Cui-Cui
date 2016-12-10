package fr.tanghevandekadsye.jee.controller.html;

import fr.tanghevandekadsye.jee.Interfaces.ContactInfo;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import fr.tanghevandekadsye.jee.SocialNetwork;
import fr.tanghevandekadsye.jee.entity.TwitterSocialNetwork;
import fr.tanghevandekadsye.jee.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String createUser(@ModelAttribute User usr)
    {
        userRepository.save(usr);

        return "subscribe_success";
    }

    @RequestMapping("/login")
    public String login(ModelMap model) {
        model.addAttribute("error-credentials", false);

        return "login-form";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, ModelMap model, @RequestParam String pseudo, @RequestParam String password) {
        User user = userRepository.findByPseudoAndPassword(pseudo, password);
        if(user != null) {
            request.getSession().setAttribute("user", user);
            model.addAttribute("error-credentials", true);

            return "login-form";
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/edit-profile")
    public String editUser() {
        return "edit_profile";
    }

    @RequestMapping(value = "/edit-profile", method = RequestMethod.POST)
    public String editUser(User user) {
        userRepository.save(user);

        return "edit_profile_success";
    }

    @RequestMapping(value = "/add-twitter", method = RequestMethod.POST)
    public String addTwitterSocialNetwork(HttpServletRequest request, @ModelAttribute TwitterSocialNetwork twitterSocialNetwork) {
        User user = (User) request.getSession().getAttribute("user"); // TODO récupérer l'utilisateur courant

        user.addSocialNetwork(twitterSocialNetwork);
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
