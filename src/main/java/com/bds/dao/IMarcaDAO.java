package com.bds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bds.model.Marca;

public interface IMarcaDAO extends JpaRepository<Marca, Integer> {

}
