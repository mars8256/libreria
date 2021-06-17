package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.ISalidaDetalleDAO;
import com.bds.model.SalidaDetalle;
import com.bds.service.ISalidaDetalleService;

@Service
public class SalidaDetalleService implements ISalidaDetalleService {

	@Autowired
	private ISalidaDetalleDAO dao;
	
	@Override
	public SalidaDetalle registrar(SalidaDetalle t) {
		return dao.save(t);
	}

	@Override
	public SalidaDetalle modificar(SalidaDetalle t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);	
	}

	@Override
	public Optional<SalidaDetalle> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<SalidaDetalle> listar() {
		return dao.findAll();
	}

}
