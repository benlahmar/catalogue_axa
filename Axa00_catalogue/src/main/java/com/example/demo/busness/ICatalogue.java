package com.example.demo.busness;

import java.util.List;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

public interface ICatalogue {

	public Produit addProduit(Produit p, long idcat) throws Exception;
	public List<Produit> allprd();
	public Produit prdbyid(long id);
	public List<Produit> seuil(int s);
	public List<Produit> allprd(long idcat);
	
	public void addCategorie(Categorie c);
	public List<Categorie> allcats();
	
}
