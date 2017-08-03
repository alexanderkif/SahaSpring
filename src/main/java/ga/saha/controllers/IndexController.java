package ga.saha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(ModelMap model){
        model.addAttribute("links",
                "<li class=\"active\"><a href=\"/\">Home</a></li>\n" +
                "<li><a href=\"/login\">Sign in</a></li>\n" +
                "<li><a href=\"/register\">Register</a></li>");

        model.addAttribute("titl", "Index");
        return "index";
    }
}
