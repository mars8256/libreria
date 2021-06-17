package com.bds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bds.model.CategoriaProducto;

public interface ICategoriaProductoDAO extends JpaRepository<CategoriaProducto, Integer> {

}
