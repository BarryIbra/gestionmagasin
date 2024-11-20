package com.barryibrahima.gestionmagasin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.barryibrahima.gestionmagasin.entities.Orders;
import com.barryibrahima.gestionmagasin.services.OrderService;

@RestController
@RequestMapping("/gestion-magasin/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    // Endpoint pour créer une commande
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrder = orderService.creeOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    // Endpoint pour ajouter un produit à une commande
    @PutMapping("/{orderId}/products/{productId}")
    public ResponseEntity<String> addProductToOrder(
            @PathVariable int orderId, 
            @PathVariable int productId) {
        orderService.addProductToOrde(orderId, productId);
        return ResponseEntity.ok("Produit ajouté à la commande avec succès.");
    }

    // Endpoint pour associer un client à une commande
    @PutMapping("/{orderId}/customers/{customerId}")
    public ResponseEntity<String> addCustomerToOrder(
            @PathVariable int orderId, 
            @PathVariable int customerId) {
        orderService.addCustomerToOrder(orderId, customerId);
        return ResponseEntity.ok("Client ajouté à la commande avec succès.");
    }

    // Endpoint pour retirer un produit d'une commande
    @DeleteMapping("/{orderId}/products/{productId}")
    public ResponseEntity<String> removeProductFromOrder(
            @PathVariable int orderId, 
            @PathVariable int productId) {
        orderService.removeProductFromOrder(orderId, productId);
        return ResponseEntity.ok("Produit retiré de la commande avec succès.");
    }

    // Endpoint pour supprimer une commande
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Commande supprimée avec succès.");
    }
}
