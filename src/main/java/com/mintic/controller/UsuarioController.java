package com.mintic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.mintic.dao.UsuarioDao;
import com.mintic.model.Usuario;



@Controller
public class UsuarioController {

	
	@Autowired
	UsuarioDao usuarioDao;
	
	
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
	
}
