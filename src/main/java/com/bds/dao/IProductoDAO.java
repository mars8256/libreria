package com.bds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bds.model.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {

}
