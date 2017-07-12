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
        model.addAttribute("links", "<a href=\"/\">Индекс</a><br/>" +
                "<a href=\"/login\">Логин</a><br/>" +
                "<a href=\"/safe\">Safe</a><br/>");
        model.addAttribute("titl", "Индекс");
        return "index";
    }
}
