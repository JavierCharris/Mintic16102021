package com.mintic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mintic.controller.services.ProveedoresServicesImpl;
import com.mintic.dao.ProductoDao;
import com.mintic.dao.ProveedorDao;
import com.mintic.model.Producto;
import com.mintic.model.Proveedor;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;






@Controller
public class ProductoController {


	
	@Autowired
	ProductoDao productoDao;
	
	@Autowired
	ProveedorDao proveedorDao;
	
	@Autowired
	ProveedoresServicesImpl proveedorServices;

	
	
	@GetMapping("/gestionproducto")
	public String gestionproducto(Model modelo, Producto producto) {
		
		List<Proveedor> listProveedor = proveedorServices.listarProveedores();	    
		 		
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("productos", productoDao.findAll());
		modelo.addAttribute("proveedores", listProveedor);	
		return "gestionproducto";
		
	}
	
	
	@PostMapping("/crearProducto")
	public String crearProducto(Model modelo, Producto producto) {
		
		productoDao.save(producto);
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("productos", productoDao.findAll());
		return "gestionproducto";
		
	}
	
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(Model modelo,@PathVariable(name="id") Long codigo) {
		Producto productoParaEditar = productoDao.findById(codigo).get();
		modelo.addAttribute("producto",productoParaEditar );
		modelo.addAttribute("productos", productoDao.findAll());
		return "gestionproducto";
		
	}
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(Model modelo,@PathVariable(name="id") Long codigo) {
		Producto productoParaEliminar = productoDao.findById(codigo).get();
		productoDao.delete(productoParaEliminar);
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("productos", productoDao.findAll());
		return "gestionproducto";
		
	}
	
	
	
	
	
	
}
