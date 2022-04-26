
package com.example.shosai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class admiController {
    @GetMapping("/administrador")
    public String admi() {
        return "administrador";
    }
    
}
