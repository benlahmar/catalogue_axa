package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.demo.entities.Produit;

public interface IProduit extends JpaRepository<Produit, Long>{

	//les produit dont la qte<seuil
	List<Produit> findByQuanityLessThan(int seuil);
	@Query("from Produit p where p.quanity<?1")
	List<Produit> findBySeuil(int seuil);
	
	@Query("from Produit p where p.categorie.id=?1")
	List<Produit> findBycat(long idcat);
	
	@Query("from Produit p where p.quanity<?1")
	List<ProduitDTO> findBySeuil2(int seuil);
	
	@Procedure(name="GetProduit")
	List<Produit> getprds();
	
	@Query(value =  "call GetProduit",nativeQuery = true)
	List<Produit> allprd();
}
