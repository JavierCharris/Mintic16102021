package com.mintic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mintic.model.Proveedor;


@Repository
public interface ProveedorDao extends CrudRepository<Proveedor, Long>{

}
