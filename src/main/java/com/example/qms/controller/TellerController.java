package com.example.qms.controller;

import com.example.qms.model.Teller;
import com.example.qms.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TellerController {

    @Autowired
    TellerService tellerService;

    @RequestMapping("/alltaller")
    public String alltaller(Model model) {
        List<Teller> tellerList = tellerService.findAll();
        model.addAttribute("tellerList", tellerList);
        return "alltaller";
    }

    @RequestMapping("/addtaller")
    public String addtaller(Model model) {
        Teller teller = new Teller();
        model.addAttribute("teller", teller);
        return "addteller";
    }

    @RequestMapping(value = "/saveteller", method = RequestMethod.POST)
    public String saveteller(@ModelAttribute("teller") Teller teller) {
        tellerService.save(teller);
        return "redirect:/addtaller";
    }

    @RequestMapping("/getteller/{id}")
    public String gettellerid(Model model, @PathVariable(name = "id") String id) {
        Teller teller = tellerService.findById(id);
        model.addAttribute("teller", teller);
        return "updateuser";
    }
}
