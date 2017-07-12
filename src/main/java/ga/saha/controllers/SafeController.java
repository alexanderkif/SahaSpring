package ga.saha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/safe")
public class SafeController {

    @RequestMapping(method = RequestMethod.GET)
    public String safePage(ModelMap model){
        model.addAttribute("links", "<a href=\"/\">Индекс</a><br/>" +
                "<a href=\"/login\">Логин</a><br/>" +
                "<a href=\"/safe\">Safe</a><br/>");
        model.addAttribute("titl", "Safe");
        return "safe";
    }
}
