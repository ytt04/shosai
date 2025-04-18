package com.example.shosai.controller;

import com.example.shosai.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.shosai.Dao.UsuarioDao;

@Controller
public class principalController {

    @GetMapping("/")
    public String index() {
        return "pagprincipal";
    }

    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }

    @GetMapping("/cliente")
    public String cliente() {
        return "cliente";
    }

    @GetMapping("/empleado")
    public String empleado() {
        return "empleado";
    }

}
