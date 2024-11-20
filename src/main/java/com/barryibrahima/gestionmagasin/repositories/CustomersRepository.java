package com.barryibrahima.gestionmagasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barryibrahima.gestionmagasin.entities.Customer;

@Repository
public interface CustomersRepository  extends JpaRepository<Customer, Integer> {

}
