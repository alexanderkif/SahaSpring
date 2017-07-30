package ga.saha.controllers;

import ga.saha.entitys.UserEntity;
import ga.saha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/safe")
public class SafeController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String safePage(ModelMap model){
        model.addAttribute("links", "<a href=\"/\">Index</a><br/>" +
                "<a href=\"/login\">Login</a><br/>" +
                "<a href=\"/safe\">Safe</a><br/>");
        model.addAttribute("titl", "Safe");

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname("Alex1");
        userEntity.setLastname("Kif1");

        // Save
        userService.addNewUser(userEntity);

        // Get saved
//        UserEntity user = userService.getUser((long) userEntity.getIdUser());
//        System.out.println("getted user: " + user);

        return "safe";
    }
}
