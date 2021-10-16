package com.mintic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@GetMapping({"/","/login"})
	public String index(){
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu(){
		return "menu";
	}
	

	
	@RequestMapping("/validador")
	public String validador(ModelMap model,  HttpServletRequest req) {
		
	
		String usuario = req.getParameter("usuario");
		String password = req.getParameter("password");
		
		if(usuario.equals("admininicial") && password.equals("admin123456") ) {
			return "menu";
			
		}else {
			model.put("error","Datos invalidos...");
			return "index";
		}	
	}
	
	
	
	
}
