package com.mintic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.dao.ProveedorDao;
import com.mintic.model.Proveedor;


@Controller
public class ProveedorController {

	@Autowired
	ProveedorDao proveedorDao;
	
	@GetMapping("/gestionproveedor")
	public String gestionproveedor(Model modelo, Proveedor proveedor) {
		modelo.addAttribute("proveedor", new Proveedor());
		modelo.addAttribute("proveedores", proveedorDao.findAll());	
		return "gestionproveedor";
		
	}
	
	
	@PostMapping("/crearProveedor")
	public String crearProveedor(Model modelo, Proveedor proveedor) {
		proveedorDao.save(proveedor);
		modelo.addAttribute("proveedor", new Proveedor());
		modelo.addAttribute("proveedores", proveedorDao.findAll());
		return "gestionproveedor";
		
	}
	
	@GetMapping("/editarProveedor/{id}")
	public String editarProveedor(Model modelo,@PathVariable(name="id") Long nit) {
		Proveedor proveedorParaEditar = proveedorDao.findById(nit).get();
		modelo.addAttribute("proveedor",proveedorParaEditar );
		modelo.addAttribute("proveedores", proveedorDao.findAll());
		return "gestionproveedor";
		
	}
	
	@GetMapping("/eliminarProveedor/{id}")
	public String eliminarProveedor(Model modelo,@PathVariable(name="id") Long nit) {
		Proveedor proveedorParaEliminar = proveedorDao.findById(nit).get();
		proveedorDao.delete(proveedorParaEliminar);
		modelo.addAttribute("proveedor", new Proveedor());
		modelo.addAttribute("proveedores", proveedorDao.findAll());
		return "gestionproveedor";
		
	}
	
	
}
