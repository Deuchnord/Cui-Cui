package fr.tanghevandekadsye.jee.controller.html;

import fr.tanghevandekadsye.jee.Interfaces.Repository.MessageRepository;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import fr.tanghevandekadsye.jee.entity.Message;
import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerome on 11/12/16.
 */
@Controller
public class SearchHtmlController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/search")
    public String search(ModelMap modelMap, @RequestParam String q) {
        List<User> users = searchUsers(q);
        List<Message> messages = searchMessages(q);

        modelMap.addAttribute("query", q);
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("messages", messages);

        return "search";
    }

    public List<User> searchUsers(String q) {
        List<User> users = new ArrayList<>();

        List<User> usersFoundByPseudo = userRepository.findByPseudo(q);
        List<User> usersFoundByName = userRepository.findByNom(q);

        users.addAll(usersFoundByPseudo);
        users.addAll(usersFoundByName);
        return users;
    }

    public List<Message> searchMessages(String q)
    {
        return messageRepository.findByText(q);
    }

    @RequestMapping("/hashtag/{word}")
    public String searchHashtag(ModelMap modelMap, @PathVariable String word)
    {
        modelMap.addAttribute("messages", this.messageRepository.findByHashtags(word));
        modelMap.addAttribute("query", word);
        return "search-hashtag";
    }

    @RequestMapping("/hashtag")
    public String searchHashtagWithParam(ModelMap modelMap, @RequestParam String q) {
        return searchHashtag(modelMap, q);
    }
}

