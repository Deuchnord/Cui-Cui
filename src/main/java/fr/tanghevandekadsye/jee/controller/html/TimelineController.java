package fr.tanghevandekadsye.jee.controller.html;

import fr.tanghevandekadsye.jee.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tanghe on 05/12/16.
 */
@Controller
public class TimelineController {
    @RequestMapping("/timeline")
    public String displayTimeline(HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");

        model.addAttribute("username", user.getNom());
        return "timeline_main";
    }

    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public String sendMessage(@RequestBody String message) {
        // TODO
        return null;
    }
}
