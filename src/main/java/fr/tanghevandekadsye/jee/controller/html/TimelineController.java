package fr.tanghevandekadsye.jee.controller.html;

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
    public String displayTimeline(Model model) {
        model.addAttribute("username", "Jean-Pierre");
        return "timeline_main";
    }

    @RequestMapping(value = "/send-message", method = RequestMethod.POST)
    public String sendMessage(@RequestBody String message) {
        // TODO
        return null;
    }
}
