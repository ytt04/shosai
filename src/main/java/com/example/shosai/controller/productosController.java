package com.example.shosai.controller;

import com.example.shosai.Dao.InventariosDao;
import com.example.shosai.Dao.ProductosDao;
import com.example.shosai.domain.CrudProductos;
import com.example.shosai.domain.Inventarios;
import java.io.IOException;
import com.example.shosai.domain.UploadFile;
import com.opencsv.exceptions.CsvValidationException;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class productosController {

	@Autowired
	private ProductosDao ProductosDao;

	@Autowired
	private InventariosDao inventariosDao;

	@GetMapping("/crudProductos")
	public String crudP(Model model) {
		List<CrudProductos> lstProductos = new ArrayList<>();
		List<CrudProductos> lstProductosModificar = new ArrayList<>();

		lstProductos = (List<CrudProductos>) ProductosDao.listarProductosEliminar();
		lstProductosModificar = (List<CrudProductos>) ProductosDao.listarProductos();

		model.addAttribute("lstProductosModificar", lstProductosModificar);
		model.addAttribute("lstProductos", lstProductos);
		return "crudProductos";
	}

	public String Cproductos(Model model) {
		CrudProductos obj = new CrudProductos();
		CrudProductos aux;
		List<CrudProductos> lstProductos = new ArrayList<>();

		lstProductos = (List<CrudProductos>) ProductosDao.findAll();

		model.addAttribute("lstProductos", lstProductos);
		model.addAttribute("productos", obj);
		return "productos";
	}

	@GetMapping("/verProductos")
	public String verProducto() {
		return "productos";
	}

	@GetMapping("/registroProducto")
	public String registroP(CrudProductos crudProductos, Model model) {
		List<Inventarios> lstInventarios = (List<Inventarios>) inventariosDao.findAll();
		model.addAttribute("lstInventarios", lstInventarios);
		return "registroProducto";
	}

	@PostMapping("/guardarProducto")
	public String guardarProducto(CrudProductos crudProductos) {
		ProductosDao.save(crudProductos);
		return "redirect:crudProductos";
	}

	@RequestMapping("/eliminarProducto")
	public String eliminarProducto(@RequestParam(name = "idproducto", defaultValue = "0") Integer idproducto) {
		ProductosDao.deleteById(idproducto);
		return "redirect:crudProductos";
	}

	@RequestMapping("/modificarProducto")
	public String modificarProducto(@RequestParam(name = "idproducto", defaultValue = "0") Integer idproducto,
			Model model) {
		CrudProductos crudProductos = ProductosDao.findById(idproducto).orElse(null);
		List<Inventarios> lstInventarios = (List<Inventarios>) inventariosDao.findAll();
		model.addAttribute("lstInventarios", lstInventarios);
		model.addAttribute("crudProductos", crudProductos);
		return "registroProducto";
	}

	@RequestMapping("/uploadFile")
	public String saveFileExcel(MultipartFile file, Model model) throws IOException, CsvValidationException {
		UploadFile upl = new UploadFile();
		List<CrudProductos> listCrudProductos = upl.guardarFile(file);

		this.ProductosDao.saveAll(listCrudProductos);

		return "redirect:crudProductos";
	}

}
