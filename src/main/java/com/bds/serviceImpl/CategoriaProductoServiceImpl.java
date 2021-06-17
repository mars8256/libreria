package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.ICategoriaProductoDAO;
import com.bds.model.CategoriaProducto;
import com.bds.service.ICategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements ICategoriaProductoService {

	@Autowired
	private ICategoriaProductoDAO dao;
	
	@Override
	public CategoriaProducto registrar(CategoriaProducto t) {
		return dao.save(t);
	}

	@Override
	public CategoriaProducto modificar(CategoriaProducto t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<CategoriaProducto> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<CategoriaProducto> listar() {
		return dao.findAll();
	}

}
