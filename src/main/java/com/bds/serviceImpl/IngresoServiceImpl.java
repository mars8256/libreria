package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.IIngresoDAO;
import com.bds.model.Ingreso;
import com.bds.service.IIngresoService;

@Service
public class IngresoServiceImpl implements IIngresoService {

	@Autowired
	private IIngresoDAO dao;
	
	@Override
	public Ingreso registrar(Ingreso t) {
		return dao.save(t);
	}

	@Override
	public Ingreso modificar(Ingreso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);	
	}

	@Override
	public Optional<Ingreso> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Ingreso> listar() {
		return dao.findAll();
	}

}
