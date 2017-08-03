package ga.saha.controllers;

import ga.saha.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    private String lform;
    private String email;
    private String pass;

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(ModelMap model){

        try{
            email = request.getParameter("email");
            pass = request.getParameter("pass");
        } catch (Exception e){
            System.out.println("No parameters");
        }

        if (email==null || pass==null) {
            lform = "<div class=\"container fo\"><br>\n" +
                    "  <form action=\"/login\" method=\"GET\" name=\"model\">\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"email\" class=\"col-sm-2 col-form-label col-sm-offset-2 lefted\">Email</label>\n" +
                    "      <div class=\"col-sm-7 col-sm-offset-2\">\n" +
                    "        <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Email\">\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "    <div class=\"form-group row\">\n" +
                    "      <label for=\"pass\" class=\"col-sm-2 col-sm-offset-2 col-form-label lefted\">Password</label>\n" +
                    "      <div class=\"col-sm-offset-2 col-sm-7\">\n" +
                    "        <input type=\"password\" class=\"form-control\" id=\"pass\" placeholder=\"Password\">\n" +
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
            lform = "<p>User " + email + " authorized</p>\n";
        }

        model.addAttribute("links",
                "<li><a href=\"/\">Home</a></li>\n" +
                "<li class=\"active\"><a href=\"/login\">Sign in</a></li>\n" +
                "<li class=\"register\"><a href=\"/register\">Register</a></li>\n");
        model.addAttribute("lform", lform);
        model.addAttribute("titl", "Login");

        return "index";
    }
}
