package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Categorie;

@RepositoryRestResource()
public interface IDataRest extends JpaRepository<Categorie, Long> {

	@RestResource(path = "bylib", rel = "findByLibelle")
	public List<Categorie> findByLibelle(String lib);
	
	
	
	
	
}
