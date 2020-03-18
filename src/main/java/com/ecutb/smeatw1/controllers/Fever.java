package com.ecutb.smeatw1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {
    private double bodyTemp;

    @GetMapping({"/fever", "/corona"})
    public String corona(Model model){
        model.addAttribute("bodyTemp", bodyTemp);
        return "corona";
    }

    @PostMapping("/corona")
    public String setBodyTemp(@RequestParam(value = "bodyTempForm") String number, Model model){
        if(!number.isEmpty()){
        bodyTemp = Double.parseDouble(number);
        model.addAttribute("bodyTemp", bodyTemp);
        }
        return "redirect:/corona";
    }
}
