package com.mintic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mintic.dao.ClienteDao;
import com.mintic.dao.UsuarioDao;
import com.mintic.model.Cliente;
import com.mintic.model.Usuario;

@Controller
public class ReporteController {

	@Autowired
	UsuarioDao usuariodao;

	@Autowired
	ClienteDao clientedao;
		
	
	@GetMapping("/reporte")
	public String reporte() {
		return "reporte";
	}
	
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model modelo, Usuario usuario) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", usuariodao.findAll());	
		return "listarUsuarios";
		
	}
	
	@GetMapping("/listarClientes")
	public String listarClientes(Model modelo, Cliente cliente) {
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("clientes", clientedao.findAll());	
		return "listarClientes";
		
	}

	
}
