package com.barryibrahima.gestionmagasin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barryibrahima.gestionmagasin.entities.Customer;
import com.barryibrahima.gestionmagasin.services.CutomerService;
/**
 * CustomerController
 */
@RestController
@RequestMapping("/gestion-magasin/customers")
public class CustomerController {

    @Autowired
    private CutomerService cutomerService;
    /**
     * rechercher un client par son id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){

        return cutomerService.getCustomerById(id);

    }
    /**
     * Créer un client
     * @param c: objet client à créer
     * @return
     */

    @PostMapping("/cree")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer creeCustomer(@RequestBody Customer c){
        return cutomerService.creeCustomer(c);
    }

    /**
     * Mettre à jour un client
     * @param id : id du client
     * @param c : objet client qui contient les nouvelles informations
     * @return
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<String>  updateCutomer(@PathVariable int id,@RequestBody Customer c){
        cutomerService.updateCutomer(id, c);
        return ResponseEntity.ok("Votre compte à été mis à jour avec succès");
    }

    /**
     * Supprimer un client par son id
     * @param id
     * @return
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCutomer(@PathVariable int id){
        cutomerService.deleteCustomer(id);
        return ResponseEntity.ok("Votre compte à été supprimer avec succès");

    }


   

}
