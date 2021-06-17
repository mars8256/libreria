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
import com.bds.model.IngresoDetalle;
import com.bds.service.IIngresoDetalleService;

@Controller
@RequestMapping("/ingreso-detalle")
public class IngresoDetalleController {

	@Autowired
	private IIngresoDetalleService service;
	
	/*LIST ALL*/
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<IngresoDetalle>> listar(){
		return new ResponseEntity<List<IngresoDetalle>>(service.listar(), HttpStatus.OK);
	}
	
	/*LIST FOR ID*/
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IngresoDetalle> listarPodId(@PathVariable("id") Integer id){
	
		Optional<IngresoDetalle> ingresoDetalle = service.listarPorId(id);
		if(!ingresoDetalle.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado:" + id);
		}
		return new ResponseEntity<IngresoDetalle>(ingresoDetalle.get(),HttpStatus.OK);
	}
	
	/*REGISTER*/
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IngresoDetalle> registrar(@RequestBody IngresoDetalle ingDet) {
		IngresoDetalle ingresoDetalle = new IngresoDetalle();
		ingresoDetalle = service.registrar(ingDet);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ingresoDetalle.getIdIngresoDetalle()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	/*UPDATE*/
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody IngresoDetalle ingresoDetalle){
		service.modificar(ingresoDetalle);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*DELETE*/
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<IngresoDetalle> ingresoDetalle = service.listarPorId(id);
		if(!ingresoDetalle.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		} else {
			service.eliminar(id);
		}
	}
	
}
