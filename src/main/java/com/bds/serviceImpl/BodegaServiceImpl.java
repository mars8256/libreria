package com.bds.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bds.dao.IBodegaDAO;
import com.bds.model.Bodega;
import com.bds.service.IBodegaService;

@Service
public class BodegaServiceImpl implements IBodegaService {

	@Autowired
	private IBodegaDAO dao;
	
	@Override
	public Bodega registrar(Bodega t) {
		return dao.save(t);
	}

	@Override
	public Bodega modificar(Bodega t) {
		return dao.save(t);
	}



	@Override
	public List<Bodega> listar() {
		return dao.findAll();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Bodega> listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
