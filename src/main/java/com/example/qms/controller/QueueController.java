package com.example.qms.controller;


import com.example.qms.model.Queues;
import com.example.qms.service.QueueService;
import com.example.qms.utility.CustomDao;
import com.example.qms.utility.SequenceControlNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class QueueController {

    @Autowired
    QueueService queueService;
    @Autowired
    CustomDao customDao;

    @RequestMapping(value = "/addtoken", method = RequestMethod.POST)
    public String addtoken(@ModelAttribute("queue") Queues queue) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyymmdd");
        Date date = new Date();
        queue.setTokenStartTime(date);
        queue.setTokenNo(customDao.getNextToken().toString());
        queue.setStatus('1');
        String queueid = queueService.save(queue);
//        System.out.println(queueid);
        return "redirect:/customerscreen";
    }

    @RequestMapping(value = "/transfertoken", method = RequestMethod.POST)
    public String transfertoken(@ModelAttribute("crntqueue") Queues queue) {
        Queues queuedb = queueService.findById(queue.getId());
        queuedb.setDescription(queue.getDescription());
        queuedb.setTellerId(queue.getTellerId());
        queuedb.setStatus('5');
        String queueid = queueService.save(queuedb);
//        System.out.println(queueid);
        return "redirect:/tellerscreen";
    }


    @RequestMapping("/tellerrequest/{peram}")
    public String tellerRequest(@PathVariable(name = "peram") String peram) {
        String peramstr[] = peram.split("_");
        String queueperam = peramstr[0];
        Long queueId = Long.parseLong(peramstr[1]);
        Queues queue = queueService.findById(queueId);
        queue.setTokenEndTime(new Date());
        queue.setStatus('0');
        queue.setTellerId(1);
        String saveResult = queueService.save(queue);
        return "redirect:/tellerscreen";
    }
}
