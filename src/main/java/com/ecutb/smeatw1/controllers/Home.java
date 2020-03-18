package com.ecutb.smeatw1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> contactList = new ArrayList<>();

    @GetMapping({"/index", "/", ""})
    public String index(){
        return "index";
    }

    @GetMapping({"/about"})
    public String about(){
        return "about";
    }

    @GetMapping({"/contact", "/contacts"})
    public String contact(Model model){
        getContactList(model);
        return "contact";
    }

    @PostMapping("/contact")
    public String addContact(@RequestParam(value = "contactForm") String name, Model model){
        if(!name.isEmpty()){
            contactList.add(name);
            getContactList(model);
        }
        return "redirect:/contact";
    }

    public String getContactList(Model model){
        model.addAttribute("contacts", contactList);
        return "contact";
    }

}
