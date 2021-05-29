package com.bds.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bds.model.Bodega;

public interface IBodegaDAO extends JpaRepository<Bodega,Integer> {

}
