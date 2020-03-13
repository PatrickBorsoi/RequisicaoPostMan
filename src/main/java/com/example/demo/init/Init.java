package com.example.demo.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Curso;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.CursoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	
	@Autowired
	CursoService serviceCuço;
	
	@Autowired
	CategoriaService serviceCate;
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		Curso c1 = new Curso();
		c1.setNome("AnalyticsSystem");
		
		Curso c2 = new Curso();
		c2.setNome("ITEssentials");
		
		

		List<Curso> listaDeCursos = new ArrayList<>();
		
		listaDeCursos.add(c1);
		listaDeCursos.add(c2);
		
		serviceCuço.saveAll(listaDeCursos);
		
		for (Curso curso : listaDeCursos) {
			
			System.out.println(curso.getNome());
		}
		
/*-------------------------------------------------------------------------------------------------------------------------------------*/		
		Categoria cate1 = new Categoria();
		cate1.setNome("Boa");
		
		Categoria cate2 = new Categoria();
		cate2.setNome("Ruim");
		
		

		List<Categoria> listaDeCategorias = new ArrayList<>();
		
		listaDeCategorias.add(cate1);
		listaDeCategorias.add(cate2);
		
		serviceCate.saveAll(listaDeCategorias);
		
		 for (Categoria categoria : listaDeCategorias) {
			 
			System.out.println(categoria.getNome());
		
		}
		
		
		
		
	}
	
	
	

}
