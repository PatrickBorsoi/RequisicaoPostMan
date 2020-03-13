package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	CursoRepository cuçorepo;
	
	public Curso search(Integer id) throws ObjectNotFoundException{
		Optional<Curso> curso = cuçorepo.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Curso.class.getName()));		
	}
	
	public List<Curso> searchAll(){
		return cuçorepo.findAll();
	}
	
	public Curso save(Curso curso) {
		return cuçorepo.save(curso);
	}
	
	public List<Curso> saveAll(List<Curso> cursos){
		return cuçorepo.saveAll(cursos);
	}
	
	public Curso edit (Curso curso) throws ObjectNotFoundException{
		Curso cursoAntigo = search(curso.getId());
		cursoAntigo.setId(curso.getId());
		cursoAntigo.setNome(curso.getNome());
		
		return save(cursoAntigo);
	}
	
	public void delete(Integer id) {
		cuçorepo.deleteById(id);
	}
	
	
	
}
