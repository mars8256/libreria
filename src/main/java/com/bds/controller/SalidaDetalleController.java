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
import com.bds.model.SalidaDetalle;
import com.bds.service.ISalidaDetalleService;

@Controller
@RequestMapping("/salida-detalle")
public class SalidaDetalleController {

	@Autowired
	private ISalidaDetalleService service;
	
	/*LIST ALL*/
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalidaDetalle>> listar(){
		return new ResponseEntity<List<SalidaDetalle>>(service.listar(), HttpStatus.OK);
	}
	
	/*LIST FOR ID*/
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalidaDetalle> listarPodId(@PathVariable("id") Integer id){
	
		Optional<SalidaDetalle> salidaDetalle = service.listarPorId(id);
		if(!salidaDetalle.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado:" + id);
		}
		return new ResponseEntity<SalidaDetalle>(salidaDetalle.get(),HttpStatus.OK);
	}
	
	/*REGISTER*/
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalidaDetalle> registrar(@RequestBody SalidaDetalle salDet) {
		SalidaDetalle salidaDetalle = new SalidaDetalle();
		salidaDetalle = service.registrar(salDet);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(salidaDetalle.getIdSalidaDetalle()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	/*UPDATE*/
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody SalidaDetalle salidaDetalle){
		service.modificar(salidaDetalle);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*DELETE*/
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<SalidaDetalle> salidaDetalle = service.listarPorId(id);
		if(!salidaDetalle.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		} else {
			service.eliminar(id);
		}
	}
}
