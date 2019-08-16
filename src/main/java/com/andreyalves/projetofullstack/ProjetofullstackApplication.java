package com.andreyalves.projetofullstack;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andreyalves.projetofullstack.domian.Categoria;
import com.andreyalves.projetofullstack.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetofullstackApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRespository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetofullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRespository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
