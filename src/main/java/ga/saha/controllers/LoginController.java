package ga.saha.controllers;

import ga.saha.entitys.User;
import ga.saha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@SessionAttributes(value = "userJSP")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    private String lform;

    @RequestMapping("/login")
    public ModelAndView indexPage(@ModelAttribute("userJSP") User userJsp){

        String email = userJsp.getEmail();
        String pass = userJsp.getPassword();
        String sign = "<a href=\"/login\">Sign in</a>";

        if (Objects.equals(email, "") || Objects.equals(pass, "") || email==null || pass==null) {
            //Login form
            lform = "<div class=\"container fo\"><br>\n" +
                    "  <form action=\"/login\" method=\"POST\" name=\"model\">\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"email\" class=\"col-sm-2 col-form-label col-sm-offset-2 lefted\">Email</label>\n" +
                    "      <div class=\"col-sm-7 col-sm-offset-2\">\n" +
                    "        <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Email\">\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"password\" class=\"col-sm-2 col-sm-offset-2 col-form-label lefted\">Password</label>\n" +
                    "      <div class=\"col-sm-offset-2 col-sm-7\">\n" +
                    "        <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Password\">\n" +
                    "      <input type=\"hidden\" name=\"name\"></div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <div class=\"offset-sm-2 col-sm-7\">\n" +
                    "        <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </form>\n" +
                    "</div>";
        }
        else{
            User checkUser;
            try{
                checkUser = userService.getUserByEmail(email);
            }catch (Exception e){
                checkUser = null;
            }
            if (checkUser!=null && Objects.equals(checkUser.getEmail(), email) && Objects.equals(checkUser.getPassword(), pass)) {
                userJsp = checkUser;
                sign = "<a href=\"/out\">Sign out</a></form>";
                //Hello User
                lform = "<div class=\"container fo\">\n" +
                        "  <form action=\"/\" method=\"POST\" name=\"model\">\n" +
                        "    <div class=\"form-group row\">\n<br>" +
                        "      <label for=\"email\" class=\"col-sm-6 col-form-label col-sm-offset-3 centered\">Hello " +
                        userJsp.getName() + "!<br>You can do your job</label>\n" +
                        "    </div>\n" +
                        "    <div class=\"form-group row\">\n" +
                        "      <div class=\"col-sm-offset-3 col-sm-6 centered\">\n" +
                        "        <button type=\"submit\" class=\"btn btn-primary\">Continue</button>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "  </form>\n" +
                        "</div>";
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("links",
                "<li><a href=\"/\">Home</a></li>\n" +
                "<li class=\"active\">" + sign + "</li>\n" +
                "<li><a href=\"/register\">Register</a></li>\n");
        modelAndView.addObject("lform", lform);
        modelAndView.addObject("titl", "Login");
        modelAndView.addObject("userJSP", userJsp);

        return modelAndView;
    }
}
