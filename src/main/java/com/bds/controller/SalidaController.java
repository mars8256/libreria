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
import com.bds.model.Salida;
import com.bds.service.ISalidaService;

@Controller
@RequestMapping("/salida")
public class SalidaController {

	@Autowired
	private ISalidaService service;
	
	/*LIST ALL*/
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Salida>> listar(){
		return new ResponseEntity<List<Salida>>(service.listar(), HttpStatus.OK);
	}
	
	/*LIST FOR ID*/
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Salida> listarPodId(@PathVariable("id") Integer id){
	
		Optional<Salida> salida = service.listarPorId(id);
		if(!salida.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado:" + id);
		}
		return new ResponseEntity<Salida>(salida.get(),HttpStatus.OK);
	}
	
	/*REGISTER*/
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Salida> registrar(@RequestBody Salida sal) {
		Salida salida = new Salida();
		salida = service.registrar(sal);
		/*
		 * URI location =
		 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
		 * (salida.getIdSalida()).toUri(); return
		 * ResponseEntity.created(location).build();
		 */
		Optional<Salida> salidaReturn = service.listarPorId(salida.getIdSalida());
		return new ResponseEntity<Salida>(salidaReturn.get(), HttpStatus.OK);
	}
	
	/*UPDATE*/
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Salida salida){
		service.modificar(salida);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*DELETE*/
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Salida> salida = service.listarPorId(id);
		if(!salida.isPresent()) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		} else {
			service.eliminar(id);
		}
	}
	
}
