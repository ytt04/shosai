package com.example.shosai.controller;

import com.example.shosai.Dao.RolDao;
import com.example.shosai.domain.DatosUsuario;
import com.example.shosai.Dao.UsuarioDao;
import com.example.shosai.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.shosai.Dao.UsuarioDaoLogin;
import com.example.shosai.domain.Rol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class loginController {

    @Autowired
    private UsuarioDaoLogin usuarioDaoLogin;

    @Autowired
    private RolDao rolDao;

    @Autowired
    private UsuarioDao usuarioDao;
    
    

    @GetMapping("/index")
    public String index(Model model, Usuario usuario) {
        List<Rol> lstRoles;
        lstRoles = (List<Rol>) rolDao.findAll();
        model.addAttribute("lstRoles", lstRoles);
        return "index";
    }

    @GetMapping("/usuarios")
    public String datosusuario() {
        return "datos_cliente";
    }

    @PostMapping("/login")
    public String login(Usuario usuario) {
        Usuario validar = usuarioDaoLogin.findByIdentificaionAndClave(usuario.getIdentificaion(), usuario.getClave());
        if (validar == null) {
            return "redirect:/index";
        } else if (validar.getRoles().get(0).getNombrerol().equals("ADMINISTRADOR")) {
            return "administrador";
        } else if (validar.getRoles().get(0).getNombrerol().equals("EMPLEADO")) {
            return "empleado";
        } else if (validar.getRoles().get(0).getNombrerol().equals("CLIENTE")) {
            return "cliente";
        }
        return "redirect:/login";
    }

    @PostMapping("/registroUsuario")
    public String registroUsuario(Usuario usuario) {

        Rol rol = rolDao.findByNombrerol("CLIENTE");
        List<Rol> roles = new ArrayList<Rol>();
        roles.add(rol);
        usuario.setRoles(roles);
        usuarioDao.save(usuario);
        return "redirect:/index";
    }
    

     
    
}