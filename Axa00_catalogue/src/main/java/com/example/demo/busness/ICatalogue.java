package com.example.demo.busness;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repos.ProduitDTO;
//https://github.com/benlahmar
public interface ICatalogue {

	public Produit addProduit(Produit p, long idcat) throws Exception;
	public List<Produit> allprd();
	public Produit prdbyid(long id) throws Exception;
	public List<ProduitDTO> seuil(int s);
	public List<Produit> allprd(long idcat);
	
	public void addCategorie(Categorie c);
	public List<Categorie> allcats();
	
	Page<Categorie> catLibelleLike(String lib, int size, int page);
	
}
