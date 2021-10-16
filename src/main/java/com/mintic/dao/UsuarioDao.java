package com.mintic.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mintic.model.Usuario;


@Repository
public interface UsuarioDao extends  CrudRepository<Usuario, Long> {

}
