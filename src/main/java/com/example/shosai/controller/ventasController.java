package com.example.shosai.controller;

import com.example.shosai.Dao.VentasDao;
import com.example.shosai.domain.CrudVentas;
import com.example.shosai.Dao.ClienteDao;
import com.example.shosai.Dao.DomiciliosDao;
import com.example.shosai.domain.Cliente;
import com.example.shosai.domain.Domicilios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ventasController {

    @Autowired
    private VentasDao ventasDao;

    @Autowired
    private ClienteDao clienteDao;
    
    
    @Autowired
    private DomiciliosDao domiciliosDao;
    
    
    @GetMapping("/crudVentas")
    public String crudV(Model model) {
        List<CrudVentas> lstVentas = new ArrayList<>();
        List<CrudVentas> lstVentasModificar = new ArrayList<>();

        lstVentas = (List<CrudVentas>) ventasDao.listarVentasEliminar();
        lstVentasModificar = (List<CrudVentas>) ventasDao.listarVentas();

        model.addAttribute("lstVentasModificar", lstVentasModificar);
        model.addAttribute("lstVentas", lstVentas);
        return "crudVentas";
    }

    public String Cventas (Model model) {
        CrudVentas obj = new CrudVentas();
        CrudVentas aux;
        List<CrudVentas> lstVentas = new ArrayList<>();

        lstVentas = (List<CrudVentas>) ventasDao.findAll();
        model.addAttribute("lstVentas", lstVentas);
        model.addAttribute("ventas", obj);
        return "ventas";
    }

    @GetMapping("/registroVentas")
    public String registroV(CrudVentas crudVentas, Model model) {
        List<Cliente> lstCliente = (List<Cliente>) clienteDao.findAll();
        model.addAttribute("lstCliente", lstCliente);
        
        List<Domicilios> lstDomicilios = (List<Domicilios>) domiciliosDao.findAll();
        model.addAttribute("lstDomicilios", lstDomicilios);
   
        return "registroVentas";
    }

    @PostMapping("/guardarVenta")
    public String guardarVenta(CrudVentas crudVentas) {
        ventasDao.save(crudVentas);
        return "redirect:crudVentas";
    }

    @RequestMapping("/eliminarVenta")
    public String eliminarVenta(@RequestParam(name = "codigo_ventas", defaultValue
            = "0") Integer codigo_ventas) {
        ventasDao.deleteById(codigo_ventas);
        return "redirect:crudVentas";
    }

    @RequestMapping("/modificarVenta")
    public String modificarVentas(@RequestParam(name = "codigo_ventas", defaultValue
            = "0") Integer codigo_ventas, Model model) {
        CrudVentas crudVentas = ventasDao.findById(codigo_ventas).orElse(null);
        List<Cliente> lstCliente = (List<Cliente>) clienteDao.findAll();
        List<Domicilios> lstDomicilios = (List<Domicilios>) domiciliosDao.findAll();
        model.addAttribute("lstDomicilios", lstDomicilios);
        model.addAttribute("lstCliente", lstCliente);
        model.addAttribute("crudVentas", crudVentas);
        
        
        return "registroVentas";
    }
    
    @GetMapping("/reporteMens")
    public String reporteMens() {
        return "reporteMens";
    }
    
     @GetMapping("/informeVenta")
    public String informeVenta() {
        return "informeVenta";
    }
    
     @GetMapping("/ayuda_pago")
    public String ayuda_pago() {
        return "ayuda_pago";
    }
}