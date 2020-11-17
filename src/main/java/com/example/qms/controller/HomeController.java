package com.example.qms.controller;

import com.example.qms.model.Queues;
import com.example.qms.model.Users;
import com.example.qms.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    QueueService queueService;

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @RequestMapping("/displayscreen")
    public String displayscreen(Model model) {
        List<Queues> queuesList = queueService.findAllProcessTokens();
        model.addAttribute("listqueue", queuesList);
        return "displayscreen";
    }

    @RequestMapping("/customerscreen")
    public String customerscreen(Model model) {
        Queues queue = new Queues();
        model.addAttribute("queue", queue);
        return "customerscreen";
    }

    @RequestMapping("/manegmentscreen")
    public String manegmentscreen(Model model) {
//        Queues queue = new Queues();
//        model.addAttribute("queue", queue);
        return "manHome";
    }

    @RequestMapping("/tellerscreen")
    public String tellerscreen(Model model) {
        Users users = (Users) request.getSession().getAttribute("users");
        if (users == null) {
            return "redirect:/login/3";
        }
        Queues queue = queueService.findTopTokenById(users.getLoginDevice());
        model.addAttribute("crntqueue", queue);
        queue.setCounterNo(users.getLoginDevice());
        queue.setStatus('2');
        String saveResult = queueService.save(queue);
        List<Queues> queuelist = queueService.findWaitingToken();
        model.addAttribute("queuelist", queuelist);
        return "tellerScreen";
    }

}
