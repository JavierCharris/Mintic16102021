package com.mintic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.dao.ClienteDao;
import com.mintic.model.Cliente;



@Controller
public class ClienteController {

	@Autowired
	ClienteDao clienteDao;
	

	@GetMapping("/gestioncliente")
	public String gestioncliente(Model modelo, Cliente cliente) {
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("clientes", clienteDao.findAll());	
		return "gestioncliente";
		
	}
	
	
	@PostMapping("/crearCliente")
	public String crearCliente(Model modelo, Cliente cliente) {
		clienteDao.save(cliente);
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("clientes", clienteDao.findAll());
		return "gestioncliente";
		
	}
	
	@GetMapping("/editarCliente/{id}")
	public String editarCliente(Model modelo,@PathVariable(name="id") Long cedula) {
		Cliente clienteParaEditar = clienteDao.findById(cedula).get();
		modelo.addAttribute("cliente",clienteParaEditar );
		modelo.addAttribute("clientes", clienteDao.findAll());
		return "gestioncliente";
		
	}
	
	@GetMapping("/eliminarCliente/{id}")
	public String eliminarCliente(Model modelo,@PathVariable(name="id") Long cedula) {
		Cliente clienteParaEliminar = clienteDao.findById(cedula).get();
		clienteDao.delete(clienteParaEliminar);
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("clientes", clienteDao.findAll());
		return "gestioncliente";
		
	}
	
	
}
