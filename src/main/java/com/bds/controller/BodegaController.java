package com.bds.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bds.exception.ModeloNotFoundException;
import com.bds.model.Bodega;
import com.bds.service.IBodegaService;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

	
	@Autowired
	private IBodegaService service;
	
	//LISTAR
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Bodega>> listar(){
		return new ResponseEntity<List<Bodega>>(service.listar(), HttpStatus.OK);
		//return service.listar();
	}
	
	//LISTAR POR ID
	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Bodega> listarPorId(@PathVariable("id") Integer id){
		Optional<Bodega> bod = service.listarPorId(id);
		if(bod == null) {
			throw new ModeloNotFoundException("Id no encontrado:" + id);
		}
		return new ResponseEntity<Bodega>(bod.get(),HttpStatus.OK);
		//return new ResponseEntity<Orden>(orden.get(),HttpStatus.OK);
	}
	
	//REGISTRAR
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrar(@RequestBody Bodega bod) {
		Bodega bodega = new Bodega();
		bodega = service.registrar(bod);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bodega.getBodegaId()).toUri();
		return ResponseEntity.created(location).build();
		//return service.registrar(bodega);
	}
	
	//MODIFICAR
	@PutMapping(value="/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> modificar(@RequestBody Bodega bodega) {
		service.modificar(bodega);
		return new ResponseEntity<Object>(HttpStatus.OK);
		//return service.modificar(bodega);
	}
	
	//ELIMINAR
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Bodega> bod = service.listarPorId(id);
		if(bod == null) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}else {
			service.eliminar(id);
		}
		//service.eliminar(id);
	}
}
