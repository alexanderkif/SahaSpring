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
public class IndexController {

    private final UserService userService;
    private String lform;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userJSP")
    public User createUser() {
        return new User();
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

    @RequestMapping(value = "/out")
    public ModelAndView indexOut(@ModelAttribute("userJSP") User user) {
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

    @RequestMapping("/register")
    public ModelAndView indexRegister(@ModelAttribute("userJSP") User userJsp){

        String email = userJsp.getEmail();
        String pass = userJsp.getPassword();
        String lform;
        String sign = "<a href=\"/login\">Sign in</a>";

        if (Objects.equals(email, "") || Objects.equals(pass, "") || email==null || pass==null) {
            //Register form
            lform = "<div class=\"container fo\">\n" +
                    "  <form action=\"/register\" method=\"POST\" name=\"model\">\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label class=\"col-sm-4 col-form-label col-sm-offset-2 lefted\"><h3>New user</h3></label>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"email\" class=\"col-sm-4 col-form-label col-sm-offset-2 lefted\">email</label>\n" +
                    "      <div class=\"col-sm-7 col-sm-offset-2\">\n" +
                    "        <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Email\">\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"password\" class=\"col-sm-4 col-sm-offset-2 col-form-label lefted\">password</label>\n" +
                    "      <div class=\"col-sm-offset-2 col-sm-7\">\n" +
                    "        <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"Password\">\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <div class=\"offset-sm-2 col-sm-7\">\n" +
                    "        <button type=\"submit\" class=\"btn btn-primary\">Register</button>\n" +
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
            if (checkUser!=null && Objects.equals(checkUser.getEmail(), email)){
                //User exist form
                lform = "<div class=\"container fo\">\n" +
                        "  <form action=\"/register\" method=\"POST\" name=\"model\">\n" +
                        "    <div class=\"form-group row\">\n<br>" +
                        "      <label for=\"email\" class=\"col-sm-6 col-form-label col-sm-offset-3 centered\">User " + checkUser.getName() + " is exist</label>\n" +
                        "    <input type=\"hidden\" id=\"email\" name=\"email\" value=\"\"></div>\n" +
                        "    <div class=\"form-group row\">\n" +
                        "      <div class=\"col-sm-offset-3 col-sm-6 centered\">\n" +
                        "        <button type=\"submit\" class=\"btn btn-primary\">Continue</button>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "  </form>\n" +
                        "</div>";
            }
            else{
                userJsp = new User();
                userJsp.setEmail(email);
                userJsp.setPassword(pass);
                userJsp.setName(email.split("@")[0]); //Lets simply use nikname as name
                try{
                    userService.addNewUser(userJsp);
                    sign = "<a href=\"/out\">Sign out</a></form>";
                    //User was added successful form
                    lform = "<div class=\"container fo\">\n" +
                            "  <form action=\"/login\" method=\"POST\" name=\"model\">\n" +
                            "    <div class=\"form-group row\">\n<br>" +
                            "      <label for=\"email\" class=\"col-sm-6 col-form-label col-sm-offset-3 centered\">New user " + email + " was added successful</label>\n" +
                            "    </div>\n" +
                            "    <div class=\"form-group row\">\n" +
                            "      <div class=\"col-sm-offset-3 col-sm-6 centered\">\n" +
                            "        <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n" +
                            "      </div>\n" +
                            "    </div>\n" +
                            "  </form>\n" +
                            "</div>";
                }catch (Exception e){
                    //User is not added form
                    lform = "<div class=\"container fo\">\n" +
                            "  <form action=\"/register\" method=\"POST\" name=\"model\">\n" +
                            "    <div class=\"form-group row\">\n<br>" +
                            "      <label for=\"email\" class=\"col-sm-6 col-form-label col-sm-offset-3 centered\">New user " + email + " is not added</label>\n" +
                            "    <input type=\"hidden\" id=\"email\" name=\"email\" value=\"\"></div>\n" +
                            "    <div class=\"form-group row\">\n" +
                            "      <div class=\"col-sm-offset-3 col-sm-6 centered\">\n" +
                            "        <button type=\"submit\" class=\"btn btn-primary\">Continue</button>\n" +
                            "      </div>\n" +
                            "    </div>\n" +
                            "  </form>\n" +
                            "</div>";
                }
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("links",
                "<li><a href=\"/\">Home</a></li>\n" +
                        "<li>" + sign + "</li>\n" +
                        "<li class=\"active\"><a href=\"/register\">Register</a></li>\n");
        modelAndView.addObject("lform", lform);
        modelAndView.addObject("titl", "Add new user");
        modelAndView.addObject("userJSP", userJsp);

        return modelAndView;
    }
}
