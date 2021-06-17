package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.IIngresoDetalleDAO;
import com.bds.model.IngresoDetalle;
import com.bds.service.IIngresoDetalleService;

@Service
public class IngresoDetalleServiceImpl implements IIngresoDetalleService {

	@Autowired
	private IIngresoDetalleDAO dao;
	
	@Override
	public IngresoDetalle registrar(IngresoDetalle t) {
		return dao.save(t);
	}

	@Override
	public IngresoDetalle modificar(IngresoDetalle t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<IngresoDetalle> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<IngresoDetalle> listar() {
		return dao.findAll();
	}

}
