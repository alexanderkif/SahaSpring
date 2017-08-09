package ga.saha.controllers;

import ga.saha.entitys.User;
import ga.saha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/save")
public class SaveController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String safePage(ModelMap model){
        model.addAttribute("links", "<a href=\"/\">Index</a><br/>" +
                "<a href=\"/login\">Login</a><br/>" +
                "<li class=\"register\"><a href=\"/register\">Register</a></li>\n" +
                "<a href=\"/safe\">Save</a><br/>");
        model.addAttribute("titl", "Save");

        User user = new User();
        user.setName("Alex4");
        user.setPassword("Kif4");

        // Save
        userService.addNewUser(user);

        // Get saved
//        User user2 = userService.getUser(user.getIdUser());
//        System.out.println("getted user: " + user2);

        return "safe";
    }
}
