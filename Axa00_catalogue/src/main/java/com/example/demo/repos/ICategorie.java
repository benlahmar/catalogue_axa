package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Categorie;

public interface ICategorie extends JpaRepository<Categorie, Long> {

	List<Categorie> getbylib(String lib);
}
/*
DELIMITER $
CREATE PROCEDURE GetProduit()
BEGIN
SELECT * FROM produit; 
END$
DELIMITER ;

*/