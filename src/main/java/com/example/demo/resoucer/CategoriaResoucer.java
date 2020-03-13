package com.example.demo.resoucer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;




@RestController
@RequestMapping("/categoria")
public class CategoriaResoucer {

	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Categoria>> searchAll(){
		List<Categoria> searchAll = service.searchAll();
		
		return ResponseEntity.ok().body(searchAll);	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException{
		Categoria objCategoria = service.search(id);
		return ResponseEntity.ok().body(objCategoria);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria objCategoria){
		objCategoria = service.save(objCategoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
