package com.mintic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mintic.model.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long>{

}
