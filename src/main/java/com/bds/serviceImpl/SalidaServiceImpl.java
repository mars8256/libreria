package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.ISalidaDAO;
import com.bds.model.Salida;
import com.bds.service.ISalidaService;

@Service
public class SalidaServiceImpl implements ISalidaService {

	@Autowired
	private ISalidaDAO dao;

	@Override
	public Salida registrar(Salida t) {
		return dao.save(t);
	}

	@Override
	public Salida modificar(Salida t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Salida> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Salida> listar() {
		return dao.findAll();
	}
	
	
}
