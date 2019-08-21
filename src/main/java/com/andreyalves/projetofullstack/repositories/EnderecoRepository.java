package com.andreyalves.projetofullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andreyalves.projetofullstack.domian.Endereco; 

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	

}
