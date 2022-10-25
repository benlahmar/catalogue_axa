package com.example.demo.busness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repos.ICategorie;
import com.example.demo.repos.IProduit;

@Service
public class CatalogueImpl implements ICatalogue{

	@Autowired
	IProduit prepo;
	@Autowired
	ICategorie crepo;
	
	@Override
	public Produit addProduit(Produit p, long idcat) throws Exception {
		 Optional<Categorie> co = crepo.findById(idcat);
		 if(co.isPresent())
		 {
			 p.setCategorie(co.get());
			 return prepo.save(p);
		 }else
		 {
			 throw new Exception("cat not found");
		 }
		
		
	}

	@Override
	public List<Produit> allprd() {
		// TODO Auto-generated method stub
		return prepo.getprds();
	}

	@Override
	public Produit prdbyid(long id) {
		// TODO Auto-generated method stub
		return prepo.findById(id).get();
	}

	@Override
	public List<Produit> seuil(int s) {
		// TODO Auto-generated method stub
		return prepo.findBySeuil(s);
	}

	@Override
	public List<Produit> allprd(long idcat) {
		// TODO Auto-generated method stub
		return prepo.findBycat(idcat);
	}

	@Override
	public void addCategorie(Categorie c) {
		crepo.save(c);
		
	}

	@Override
	public List<Categorie> allcats() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

}
