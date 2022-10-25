package com.example.demo.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.busness.ICatalogue;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

@RestController
public class CatalogueApi {

	@Autowired
	ICatalogue cat;
	
	@PostMapping("/categories")
	public ResponseEntity<Void> addcategorie(@RequestBody Categorie c)
	{
		cat.addCategorie(c);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/categories")
	public List<Categorie> allcat()
	{
		return cat.allcats();
	}
	
	@PostMapping("/produits")
	public ResponseEntity<Void> addprd(@RequestBody Produit p,@RequestParam long idcat)
	{
		try {
			cat.addProduit(p, idcat);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}
	
	@GetMapping("/produits")
	@Transactional
	public List<Produit> allprd()
	{
		return cat.allprd();
	}
	
	@GetMapping("/categories/search")
	public Page<Categorie> allcatp(@RequestParam(name = "q") String lib,@RequestParam int size,@RequestParam int page)
	{
		return cat.catLibelleLike(lib, size, page);
	}
	

}
