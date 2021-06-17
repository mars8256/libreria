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
import com.bds.model.Cliente;
import com.bds.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
	private IClienteService service;
	
	//LISTAR
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Cliente>> listar(){
		return new ResponseEntity<List<Cliente>>(service.listar(), HttpStatus.OK);
		//return service.listar();
	}
	
	//LISTAR POR ID
	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id){
		Optional<Cliente> cli = service.listarPorId(id);
		if(cli == null) {
			throw new ModeloNotFoundException("Id no encontrado:" + id);
		}
		return new ResponseEntity<Cliente>(cli.get(),HttpStatus.OK);
		
	}
	
	//REGISTRAR
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Cliente> registrar(@RequestBody Cliente cli) {
		Cliente cliente = new Cliente();
		cliente = service.registrar(cli);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//MODIFICAR
	@PutMapping(value="/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> modificar(@RequestBody Cliente cliente) {
		service.modificar(cliente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//ELIMINAR
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<Cliente> cli = service.listarPorId(id);
		if(cli == null) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}else {
			service.eliminar(id);
		}
	
	}
}
