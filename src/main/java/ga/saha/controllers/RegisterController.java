package ga.saha.controllers;

import ga.saha.entitys.User;
import ga.saha.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    UserService userService;

    private String lform;
    private String email;
    private String pass;
    private User user;

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(ModelMap model){

        try{
            email = request.getParameter("email");
            if (email.equals(null)) email="";
        } catch (Exception e){
            email = "";
        }
        try{
            pass = request.getParameter("pass");
            if (pass.equals(null)) pass="";
        } catch (Exception e){
            pass = "";
        }
        try{
            user = (User) model.get(user);
        } catch (Exception e){
            user = null;
        }

        if (email.equals("") || pass.equals("")) {
            lform = "<div class=\"container fo\">\n" +
                    "  <form action=\"/register\" method=\"GET\" name=\"model\">\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label class=\"col-sm-4 col-form-label col-sm-offset-2 lefted\"><h3>New user</h3></label>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"email\" class=\"col-sm-4 col-form-label col-sm-offset-2 lefted\">email</label>\n" +
                    "      <div class=\"col-sm-7 col-sm-offset-2\">\n" +
                    "        <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Email\" " +
                    "        value=\"" + email +"\">\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"pass\" class=\"col-sm-4 col-sm-offset-2 col-form-label lefted\">password</label>\n" +
                    "      <div class=\"col-sm-offset-2 col-sm-7\">\n" +
                    "        <input type=\"password\" class=\"form-control\" id=\"pass\" placeholder=\"Password\" " +
                    "         value=\"" + pass +"\">\n" +
                    "      </div>\n" +
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
            user = new User();
            user.setEmail(email);
            user.setPassword(pass);
            try{
                userService.addNewUser(user);
                lform = "<p>New user " + email + " add successful</p>\n";
            }catch (Exception e){
                lform = "<p>New user " + email + " is not added</p>\n";
            }

        }

        model.addAttribute("links",
                "<li><a href=\"/\">Home</a></li>\n" +
                "<li><a href=\"/login\">Sign in</a></li>\n" +
                "<li class=\"active\"><a href=\"/register\">Register</a></li>\n");
        model.addAttribute("lform", lform);
        model.addAttribute("titl", "Add new user");
        model.addAttribute("user", user);

        return "index";
    }
}
