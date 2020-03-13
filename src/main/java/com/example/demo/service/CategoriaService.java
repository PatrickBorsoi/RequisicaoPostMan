package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository caterepo;
	
	public Categoria search(Integer id) throws ObjectNotFoundException{
		Optional<Categoria> categoria = caterepo.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Categoria.class.getName()));		
	}
	
	public List<Categoria> searchAll(){
		return caterepo.findAll();
	}
	
	public Categoria save(Categoria categoria) {
		return caterepo.save(categoria);
	}
	
	public List<Categoria> saveAll(List<Categoria> categorias){
		return caterepo.saveAll(categorias);
	}
	
	public Categoria edit (Categoria categoria) throws ObjectNotFoundException{
		Categoria categoriaAntigo = search(categoria.getId());
		categoriaAntigo.setId(categoria.getId());
		categoriaAntigo.setNome(categoria.getNome());
		
		return save(categoriaAntigo);
	}
	
	public void delete(Integer id) {
		caterepo.deleteById(id);
	}
	
}
