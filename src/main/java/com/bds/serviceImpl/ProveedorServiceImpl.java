package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.IProveedorDAO;
import com.bds.model.Proveedor;
import com.bds.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorDAO dao;
	
	@Override
	public Proveedor registrar(Proveedor t) {
		return dao.save(t);
	}

	@Override
	public Proveedor modificar(Proveedor t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Proveedor> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Proveedor> listar() {
		return dao.findAll();
	}

}
