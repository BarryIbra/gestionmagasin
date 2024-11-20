package com.barryibrahima.gestionmagasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barryibrahima.gestionmagasin.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}

