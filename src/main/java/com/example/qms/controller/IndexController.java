package com.example.qms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String viewIndexpage() {

        return "index";
    }

//    @RequestMapping("/cuslogin")
//public String viewCusLoginpage(){
//
//    return "customerLogin";
//}
}
