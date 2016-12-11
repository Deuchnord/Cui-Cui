package fr.tanghevandekadsye.jee.controller.html;

import fr.tanghevandekadsye.jee.Interfaces.Repository.MessageRepository;
import fr.tanghevandekadsye.jee.Interfaces.Repository.UserRepository;
import fr.tanghevandekadsye.jee.entity.Message;
import fr.tanghevandekadsye.jee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        List<User> usersFoundByName = userRepository.findByPseudo(q);

        users.addAll(usersFoundByPseudo);
        users.addAll(usersFoundByName);
        return users;
    }

    public List<Message> searchMessages(String q) {
        return messageRepository.findByText(q);
    }
}
