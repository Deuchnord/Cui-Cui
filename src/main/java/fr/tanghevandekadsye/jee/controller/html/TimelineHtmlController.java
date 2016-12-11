package fr.tanghevandekadsye.jee.controller.html;

import fr.tanghevandekadsye.jee.Interfaces.Repository.MessageRepository;
import fr.tanghevandekadsye.jee.entity.Message;
import fr.tanghevandekadsye.jee.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by tanghe on 05/12/16.
 */
@Controller
public class TimelineHtmlController {
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String displayHomePage(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("user") != null)
            return "redirect:/timeline";

        return "index.html";
    }

    @RequestMapping("/timeline")
    public String displayTimeline(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");

        if(user == null)
            return "redirect:/";

        model.addAttribute("user", user);
        model.addAttribute("messages",messageRepository.findAll());
        return "timeline_main";
    }

    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public String sendMessage(HttpServletRequest request, @RequestBody String content) {
        User user = (User) request.getSession().getAttribute("user");

        if(user == null)
            return "redirect:/login";

        Message message = new Message(user, request.getParameter("message"));
        messageRepository.save(message);

        return "redirect:/timeline";
    }

    public List<Message> searchMessage(String search) {
        return messageRepository.findByText(search);
    }
}
