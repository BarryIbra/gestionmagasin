package com.barryibrahima.gestionmagasin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.barryibrahima.gestionmagasin.entities.Produit;
import com.barryibrahima.gestionmagasin.services.ProduitService;

import java.util.List;
/**
 * ProduitController
 */
@RestController
@RequestMapping("/gestion-magasin/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    /**
     * Récupérer tous les produits
     * */
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }

   /**
    * Récupérer un produit par ID
    *  */ 
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable int id) {
        Produit produit = produitService.getProduitById(id);
        return ResponseEntity.ok(produit);
    }

    /**
     * Récupérer des produits par nom
     * */
    @GetMapping("/search")
    public ResponseEntity<List<Produit>> getProduitsByNom(@RequestParam String nom) {
        List<Produit> produits = produitService.getProduitsByNom(nom);
        return ResponseEntity.ok(produits);
    }

    /**
     *  Créer un produit
     * @param produit: produit à créer
     * @return
     */
    @PostMapping
    public ResponseEntity<Produit> creeProduit(@RequestBody Produit produit) {
        Produit nouveauProduit = produitService.creeProduit(produit);
        return ResponseEntity.ok(nouveauProduit);
    }

    /**
     * Supprimer un produit par ID
     * */ 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduit(@PathVariable int id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok("Produit supprimé avec succès !");
    }
}
