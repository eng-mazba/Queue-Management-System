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

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/alluser")
    public String allUser(Model model) {
        List<Users> users = userService.allUser();
        model.addAttribute("listusers", users);
        return "alluser";
    }

    @RequestMapping("/getuser/{id}")
    public String geteuserbyid(Model model, @PathVariable(name = "id") Integer id) {
        Users users = userService.findById(id);
        model.addAttribute("user", users);
        return "updateuser";
    }

    @RequestMapping("/adduser")
    public String adduser(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "adduser";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveuser(@ModelAttribute("users") Users users) {
        userService.save(users);
        return "redirect:/adduser";
    }
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateuser(@ModelAttribute("users") Users users) {
        Users dbuser = userService.findById(users.getId());
        dbuser.setUserStatus(users.getUserStatus());
        dbuser.setValidityDate(users.getValidityDate());
        dbuser.setUserType(users.getUserType());
        userService.save(dbuser);
        return "redirect:/alluser";
    }
}
