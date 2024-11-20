package com.barryibrahima.gestionmagasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barryibrahima.gestionmagasin.entities.Produit;
import com.barryibrahima.gestionmagasin.repositories.ProduitRepository;
import com.barryibrahima.gestionmagasin.execptions.ProduitNotFoundExecption;
/**
 * Service pour l'entite Produit
 */
@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;


    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public  Produit getProduitById(int id)  {
        Produit produit=produitRepository.findById(id).orElseThrow(()->new ProduitNotFoundExecption("Produit introuvable"));
        return produit;
    }

    public List<Produit> getProduitsByNom(String nom) {
        return produitRepository.findByNom(nom);
    }

    public Produit creeProduit(Produit produit) {
        return produitRepository.save(produit);
    }



    public void deleteProduit(int id) {
        produitRepository.deleteById(id);
    }

    
}
