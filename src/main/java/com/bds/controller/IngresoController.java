package com.bds.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bds.exception.ModeloNotFoundException;
import com.bds.model.Ingreso;
import com.bds.service.IIngresoService;

@Controller
@RequestMapping("/ingreso")
public class IngresoController {

	@Autowired
	private IIngresoService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingreso>> listar(){
		return new ResponseEntity<List<Ingreso>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingreso> listarPorId(@PathVariable("id") Integer id){
		Optional<Ingreso> ingreso = service.listarPorId(id);
		if(!ingreso.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}
		return new ResponseEntity<Ingreso>(ingreso.get(), HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingreso> registrar(@RequestBody Ingreso ing) {
		Ingreso ingreso = new Ingreso();
		ingreso = service.registrar(ing);
		Optional<Ingreso> ingresoReturn = service.listarPorId(ingreso.getIdIngreso());
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingreso.getIdIngreso()).toUri();
		//return ResponseEntity.created(location).build();
		return new ResponseEntity<Ingreso>(ingresoReturn.get(), HttpStatus.OK);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Ingreso ingreso){
		service.modificar(ingreso);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Ingreso> ingreso = service.listarPorId(id);
		if(!ingreso.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		} else {
			service.eliminar(id);
		}
	}
	
	
}
