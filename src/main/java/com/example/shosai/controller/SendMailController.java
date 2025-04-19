/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.controller;

import com.example.shosai.domain.MailService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author HP
 */
@Controller
public class SendMailController {
    
    @Autowired
    private MailService mailService;
 
    @GetMapping("/correo")
    public String correo() {
        return "pagprincipal";
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body) {
 
        String message = body + "\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.sendMail("shosai.sys@gmail.com", "paginayurley@gmail.com", subject, message);
 
        return "pagprincipal";
    }
}
