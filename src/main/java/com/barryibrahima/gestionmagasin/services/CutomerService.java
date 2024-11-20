package com.barryibrahima.gestionmagasin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barryibrahima.gestionmagasin.entities.Customer;
import com.barryibrahima.gestionmagasin.repositories.CustomersRepository;
import com.barryibrahima.gestionmagasin.execptions.CustomerNotFoundException;

/**
 * Service pour l'entite Customer
 */
@Service
public class CutomerService {
    @Autowired
    private CustomersRepository customersRepository;


     public Customer creeCustomer(Customer customer) {
        return customersRepository.save(customer);

    }

    public Customer getCustomerById(int id)  {
        return customersRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Utilisateur introuvable"));
    }

    public void updateCutomer(int id,Customer c)
    {
        Customer customer=customersRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Cet utilisateur n'existe pas"));
        customer.setNom(c.getNom());
        customer.setPrenom(c.getPrenom());
        customer.setEmail(c.getEmail());
        customersRepository.save(customer);

    }

    public void deleteCustomer(int id) {
        if(customersRepository.findById(id).isPresent())
            customersRepository.deleteById(id);
        else
            throw new CustomerNotFoundException("Cet utilisateur n'existe pas");

        
    }


}
