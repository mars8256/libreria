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
import com.bds.model.CategoriaProducto;
import com.bds.service.ICategoriaProductoService;

@RestController
@RequestMapping("/cat-producto")
public class CategoriaProductoController {

	
	@Autowired
	private ICategoriaProductoService service;
	
	//LISTAR
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CategoriaProducto>> listar(){
		return new ResponseEntity<List<CategoriaProducto>>(service.listar(), HttpStatus.OK);
	}
	
	//LISTAR POR ID
	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CategoriaProducto> listarPorId(@PathVariable("id") Integer id){
		Optional<CategoriaProducto> catProd = service.listarPorId(id);
		if(catProd == null) {
			throw new ModeloNotFoundException("Id no encontrado:" + id);
		}
		return new ResponseEntity<CategoriaProducto>(catProd.get(),HttpStatus.OK);
		
	}
	
	//REGISTRAR
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<CategoriaProducto> registrar(@RequestBody CategoriaProducto catProd) {
		CategoriaProducto categoriaProducto = new CategoriaProducto();
		categoriaProducto = service.registrar(catProd);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoriaProducto.getIdCategoriaProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//MODIFICAR
	@PutMapping(value="/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> modificar(@RequestBody CategoriaProducto catProd) {
		service.modificar(catProd);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//ELIMINAR
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Optional<CategoriaProducto> cat = service.listarPorId(id);
		if(cat == null) {
			throw new ModeloNotFoundException("id no encontrado: " + id);
		}else {
			service.eliminar(id);
		}
	
	}
	
}
