package com.barryibrahima.gestionmagasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barryibrahima.gestionmagasin.entities.Produit;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit, Integer> {

    public List<Produit> findByNom(String nom);

}
