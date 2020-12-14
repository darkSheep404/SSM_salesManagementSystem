package com.dgut.ssm.controller;

import com.dgut.ssm.bean.Contact;
import com.dgut.ssm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService service;
    @GetMapping("/list")
    public String list(Model model) {
        List<Contact> contacts=service.getAllContact();
        model.addAttribute("contacts",contacts);
        /*List<Goods> goods = service.getAllGoods();
        model.addAttribute("goods", goods);
        return "goodList";*/
        return "contactList";
    }
}
