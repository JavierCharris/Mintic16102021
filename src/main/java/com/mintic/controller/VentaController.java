package com.mintic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.controller.services.ProveedoresServicesImpl;
import com.mintic.dao.ClienteDao;
import com.mintic.dao.ProductoDao;
import com.mintic.dao.UsuarioDao;
import com.mintic.model.Cliente;
import com.mintic.model.Producto;
import com.mintic.model.Usuario;

@Controller
public class VentaController {

	
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	ClienteDao clienteDao;
	
	@Autowired
	ProductoDao productoDao;
	
	@Autowired
	ProveedoresServicesImpl proveedorServices;
	
	@GetMapping("/venta")
	public String venya(Model modelo, Cliente cliente) {
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("clientes", clienteDao.findAll());	
		return "venta";
		
	}
	
	@GetMapping("/consultarCliente/")
	public String consultarCliente(Model modelo,Cliente cliente,ModelMap model) {
		Cliente clienteParaEditar = clienteDao.findById(cliente.getCedula()).get();
		modelo.addAttribute("cliente",clienteParaEditar );
		modelo.addAttribute("clientes", clienteDao.findAll());
		model.put("message","Cliente encontrado...");
		return "venta";
		
	}
	
	/*
	@GetMapping("/venta")
	public String gestioncliente(Model modelo, Cliente cliente) {
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("clientes", clienteDao.findAll());	
		return "consultarCliente";
		
	}
	*/
	

	
	/*
	
	@GetMapping("/gestionusuario")
	public String gestionusuario(Model modelo, Usuario usuario) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioDao.findAll());	
		return "gestionusuario";
		
	}
	
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(Model modelo, Usuario usuario) {
		usuarioDao.save(usuario);
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioDao.findAll());
		return "gestionusuario";
		
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String crearUsuario(Model modelo,@PathVariable(name="id") Long cedula) {
		Usuario usuarioParaEditar = usuarioDao.findById(cedula).get();
		modelo.addAttribute("usuario",usuarioParaEditar );
		modelo.addAttribute("usuarios", usuarioDao.findAll());
		return "gestionusuario";
		
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model modelo,@PathVariable(name="id") Long cedula) {
		Usuario usuarioParaEliminar = usuarioDao.findById(cedula).get();
		usuarioDao.delete(usuarioParaEliminar);
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuarioDao.findAll());
		return "gestionusuario";
		
	}
	
	*/
	
}
