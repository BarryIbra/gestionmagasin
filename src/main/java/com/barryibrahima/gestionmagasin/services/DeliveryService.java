package com.barryibrahima.gestionmagasin.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barryibrahima.gestionmagasin.entities.Delivery;
import com.barryibrahima.gestionmagasin.entities.Orders;
import com.barryibrahima.gestionmagasin.execptions.ResourceNotFoundException;
import com.barryibrahima.gestionmagasin.repositories.DeliveryRepository;
import com.barryibrahima.gestionmagasin.repositories.OrdersRepository;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private OrdersRepository orderRepository;

    public Delivery createDelivery(int orderId, String address) {
        Orders order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Cette commande n'existe pas"));

        if (!order.getStatus()) {
            throw new ResourceNotFoundException("La commande n'est pas encore prête pour la livraison");
        }

        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setAddress(address);
        delivery.setDeliveryDate(new Date());
        delivery.setStatus("ATTENTE");

        return deliveryRepository.save(delivery);
    }

    public Delivery updateDeliveryStatus(int deliveryId, String status) {
        Delivery delivery = deliveryRepository.findById(deliveryId)
            .orElseThrow(() -> new ResourceNotFoundException("Cette livraison n'existe pas"));

        delivery.setStatus(status);
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
}
