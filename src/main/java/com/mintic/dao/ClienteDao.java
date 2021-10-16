package com.mintic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mintic.model.Cliente;


@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
