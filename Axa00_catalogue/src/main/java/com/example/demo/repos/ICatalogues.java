package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Categorie;

//@RepositoryRestResource(collectionResourceRel = "catalogues",itemResourceRel = "cat")
public interface ICatalogues extends JpaRepository<Categorie, Long>{

	public List<Categorie> findByLibelle(String key);
	
//	@RestResource(exported = false)
//	public void deleteById(long id);
}
