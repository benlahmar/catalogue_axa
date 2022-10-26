package com.example.demo.busness;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repos.ICategorie;
import com.example.demo.repos.IProduit;
import com.example.demo.repos.ProduitDTO;

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
	@Transactional
	public List<Produit> allprd() {
		
		return prepo.getprds();
	}

	@Override
	public Produit prdbyid(long id) throws Exception {
		// TODO Auto-generated method stub
		 Optional<Produit> op = prepo.findById(id);
		 if(op.isPresent())
		  return op.get();
		 else
			 throw new Exception("not found");
		 
	}

	@Override
	public List<ProduitDTO> seuil(int s) {
		// TODO Auto-generated method stub
		return prepo.findBySeuil2(s);
	}

	@Override
	public List<Produit> allprd(long idcat) {
		// TODO Auto-generated method stub
		return prepo.findBycat(idcat);
	}

	@Override
	public void addCategorie(Categorie c) {
		//log4j	
		//validation data
		//
		crepo.save(c);
		
	}

	@Override
	public List<Categorie> allcats() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public Page<Categorie> catLibelleLike(String lib, int size,int page) {
		
		Pageable pg=PageRequest.of(page, size);
		return crepo.findByLibelleLike(lib, pg);
		 
	}

}
