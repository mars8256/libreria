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
import com.bds.model.Marca;
import com.bds.service.IMarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	
	@Autowired
	private IMarcaService service;
	
	//LISTAR
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Marca>> listar(){
		return new ResponseEntity<List<Marca>>(service.listar(), HttpStatus.OK);
	}
	
	//LISTAR POR ID
	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Marca> listarPorId(@PathVariable("id") Integer id){
		Optional<Marca> mar = service.listarPorId(id);
		if(mar == null) {
			throw new ModeloNotFoundException("Id no encontrado:" + id);
		}
		return new ResponseEntity<Marca>(mar.get(),HttpStatus.OK);
		
	}
	
	//REGISTRAR
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Marca> registrar(@RequestBody Marca mar) {
		Marca marca = new Marca();
		marca = service.registrar(mar);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getIdMarca()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//MODIFICAR
	@PutMapping(value="/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> modificar(@RequestBody Marca mar) {
		service.modificar(mar);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//ELIMINAR
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Marca> mar = service.listarPorId(id);
		if(mar == null) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}else {
			service.eliminar(id);
		}
	
	}
}
