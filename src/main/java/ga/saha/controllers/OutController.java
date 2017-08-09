package ga.saha.controllers;

import ga.saha.entitys.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value = "userJSP")
public class OutController {

    @RequestMapping(value = "/out")
    public ModelAndView main(@ModelAttribute("userJSP") User user, SessionStatus sessionStatus) {
        //sessionStatus.setComplete();
        //return new ModelAndView("index", "userJSP", new User());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("links",
                        "<li class=\"active\"><a href=\"/\">Home</a></li>\n" +
                        "<li><a href=\"/login\">Sign in</a></li>\n" +
                        "<li><a href=\"/register\">Register</a></li>");
        modelAndView.addObject("titl", "Login");
        modelAndView.addObject("userJSP", new User());
        return modelAndView;
    }
}
