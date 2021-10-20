package com.mintic.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.dao.ProveedorDao;
import com.mintic.model.Proveedor;

@Service
public class ProveedoresServicesImpl implements ProveedoresServices{

	
	@Autowired
	private ProveedorDao proveedorDao;
	
	@Override
	public List<Proveedor> listarProveedores() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) proveedorDao.findAll();
	}

}
