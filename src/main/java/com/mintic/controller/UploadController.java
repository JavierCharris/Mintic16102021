package com.mintic.controller;



import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.mintic.dao.ProductoDao;
import com.mintic.dao.ProveedorDao;
import com.mintic.model.Producto;
import com.mintic.model.Proveedor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;


import com.univocity.parsers.common.record.Record;

 
@Controller
public class UploadController{
 
    private String filename;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/Users/javierenriquecharrismolina/Documents/";
 
    /*
    ** Página de carga de archivos
     */
 
    @Autowired
	ProductoDao productoDao;
    
    @Autowired
    ProveedorDao proveedorDao;
	
 
    
    @GetMapping("/upload")
    public String upload(Model modelo, Producto producto) {
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("productos", productoDao.findAll());	
        return "upload";
    }
 
    @PostMapping("/upload")
    public String singleFileUpload(Model modelo, @RequestParam("file") MultipartFile file,
    		ModelMap model) {
        if (file.isEmpty()) {
        	model.put("message", "¡El archivo está vacío! ¡Seleccione un archivo no vacío para cargar!");
            return "/upload";
        }
 
        try {
        	
        	 byte[] bytes = file.getBytes();
        	 
             filename = file.getOriginalFilename();
             
             Path path = Paths.get(UPLOADED_FOLDER + filename);
             Files.write(path, bytes);
           
          
        	List<Producto> productolist =  new ArrayList<>();
    		InputStream inputStream = file.getInputStream();
    		//if(file.getOriginalFilename().)
    		CsvParserSettings setting = new CsvParserSettings();
    		setting.setHeaderExtractionEnabled(true);
    		CsvParser parser = new CsvParser(setting);
    		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
    		parseAllRecords.forEach( record -> {
    			Producto producto = new Producto();
    			producto.setNombre(record.getString("nombre"));
    			Proveedor proveedorParaAgregar = proveedorDao.findById(Long.parseLong(record.getString("nit"))).get();
    			producto.setNit(proveedorParaAgregar);
    			
    			
    			producto.setPrecio_compra(Double.parseDouble(record.getString("precio_compra")));
    			producto.setIva_compra(Double.parseDouble(record.getString("iva_compra")));
    			producto.setPrecio_venta(Double.parseDouble(record.getString("precio_venta")));
    			productolist.add(producto);
    			
    			
    		});
    		
    		
    		productoDao.saveAll(productolist);
    		model.put("message", "Has subido correctamente el archivo " + filename + "', el tamaño del archivo es aproximadamente es de " +bytes.length+" B.");
    		modelo.addAttribute("productos", productoDao.findAll());
    		return "/upload";
        
        }
        catch (IOException e) {
            e.printStackTrace();
        }
       
        return "/upload";
    }
    
    
    

  

  
 
}