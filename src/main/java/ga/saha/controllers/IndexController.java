package ga.saha.controllers;

import ga.saha.entitys.User;
import ga.saha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@SessionAttributes(value = "userJSP")
public class IndexController {

    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public ModelAndView indexPageGet(@ModelAttribute("userJSP") User userJsp) {

        String email = userJsp.getEmail();
        String pass = userJsp.getPassword();
        String sign = "<a href=\"/login\">Sign in</a>";

        User checkUser;
        try{
            checkUser = userService.getUserByEmail(email);
        }catch (Exception e){
            checkUser = null;
        }
        if (checkUser!=null && Objects.equals(checkUser.getEmail(), email) && Objects.equals(checkUser.getPassword(), pass)) {
            sign = "<a href=\"/out\">Sign out</a></form>";
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("links",
                        "<li class=\"active\"><a href=\"/\">Home</a></li>\n" +
                        "<li>" + sign + "</li>\n" +
                        "<li><a href=\"/register\">Register</a></li>");
        modelAndView.addObject("titl", "Index");
        if (Objects.equals(userJsp.getEmail(), "") || userJsp.getEmail()==null){
            modelAndView.addObject("userJSP", new User());
        }
        return modelAndView;
    }

    @ModelAttribute("userJSP")
    public User createUser() {
        return new User();
    }
}
