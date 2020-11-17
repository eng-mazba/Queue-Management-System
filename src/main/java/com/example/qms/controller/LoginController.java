package com.example.qms.controller;


import com.example.qms.model.Users;
import com.example.qms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    int usertype;
    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping("/login/{id}")
    public String viewLoginScreen(Model model, @PathVariable(name = "id") int utype) {

        Users users = new Users();
        usertype = utype;
        model.addAttribute("users", users);
        if (utype != 3) {
            return "login";
        } else {
            return "tellerLogin";
        }

    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("users") Users users, Model model) {
        Users bduser = userService.findByUserNameAndPassword(users.getUserName(), users.getPassword());
        if (bduser != null) {
            usertype = bduser.getUserType();
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
//            System.out.println(users.getLoginDevice());
            bduser.setLastLogin(date);
            if (usertype == 3) {
                bduser.setLoginDevice(users.getLoginDevice());
            } else {
                bduser.setLoginDevice(request.getRemoteAddr());
            }
            userService.save(bduser);
            request.getSession().setAttribute("users", users);
            switch (usertype) {
                case 1:
                    return "redirect:/displayscreen";
                case 2:
                    return "redirect:/customerscreen";
                case 3:
//                    model.addAttribute("counterno", users.getLoginDevice());
                    return "redirect:/tellerscreen";
                case 4:
                    return "redirect:/manegmentscreen";

            }
        }


        return "redirect:/";
    }

}