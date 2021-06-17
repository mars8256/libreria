package com.bds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bds.model.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, Integer> {

}
