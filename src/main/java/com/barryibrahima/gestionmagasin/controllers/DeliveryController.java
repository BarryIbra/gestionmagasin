package com.barryibrahima.gestionmagasin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barryibrahima.gestionmagasin.entities.Delivery;
import com.barryibrahima.gestionmagasin.services.DeliveryService;

@RestController
@RequestMapping("/gestiion-magasin/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestParam int orderId,@RequestParam String address) {
        return ResponseEntity.ok(deliveryService.createDelivery(orderId, address));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable int id, @RequestParam String status) {
        return ResponseEntity.ok(deliveryService.updateDeliveryStatus(id, status));
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }
}
