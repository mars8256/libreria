package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.IProductoDAO;
import com.bds.model.Producto;
import com.bds.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO dao;
	
	@Override
	public Producto registrar(Producto t) {
		return dao.save(t);
	}

	@Override
	public Producto modificar(Producto t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Producto> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Producto> listar() {
		return dao.findAll();
	}

}
