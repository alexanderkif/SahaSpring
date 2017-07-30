package ga.saha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(ModelMap model){
        model.addAttribute("links", "<a href=\"/\">Index</a><br/>" +
                "<a href=\"/login\">Login</a><br/>" +
                "<a href=\"/safe\">Safe</a><br/>");
        model.addAttribute("titl", "Login");

        return "index";
    }
}
