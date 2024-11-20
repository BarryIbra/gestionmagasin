package com.barryibrahima.gestionmagasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barryibrahima.gestionmagasin.entities.Orders;
import com.barryibrahima.gestionmagasin.entities.Produit;
import com.barryibrahima.gestionmagasin.execptions.CustomerNotFoundException;
import com.barryibrahima.gestionmagasin.execptions.ProduitIndisponibleException;
import com.barryibrahima.gestionmagasin.execptions.ProduitNotFoundExecption;
import com.barryibrahima.gestionmagasin.execptions.ResourceNotFoundException;
import com.barryibrahima.gestionmagasin.repositories.OrdersRepository;
/**
 * Service pour l'entite Ordre
 */

@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CutomerService cutomerService;
    @Autowired
    private DeliveryService deliveryService;

   
    public Orders creeOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public void addProductToOrde(int orderId, int productId){
        Orders order = ordersRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Commande introuvable"));
        Produit produit = produitService.getProduitById(productId);
        if(produit.getQuantite()<=0)
        {
            throw new ProduitIndisponibleException("Le produit("+produit.getNom()+") n'est plus disponible en Stock");
        }
        order.addProduit(produit);
        ordersRepository.save(order);
        
    }
    public void addCustomerToOrder(int orderId, int customerId) throws ResourceNotFoundException,CustomerNotFoundException {
        Orders order = ordersRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Commande introuvable"));
        order.setCustomer(cutomerService.getCustomerById(customerId));
        ordersRepository.save(order);
    }

    public void removeProductFromOrder(int orderId, int productId)throws ResourceNotFoundException,ProduitNotFoundExecption  {
        Orders order = ordersRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Commande introuvable"));
        Produit produit = produitService.getProduitById(productId);
        order.removeProduit(produit);
        ordersRepository.save(order);
    }

    public void deleteOrder(int id) {
        ordersRepository.deleteById(id);
    }

    public List<Orders> getOrdersByClientId(int id) {
        return ordersRepository.findByCustomerId(id);
    }

    public Orders confirmOrder(int orderId) {
    Orders order = ordersRepository.findById(orderId)
        .orElseThrow(() -> new ResourceNotFoundException("Commande introuvable"));

    if (order.getStatus()) {
        throw new ResourceNotFoundException("La commande a déjà été confirmée");
    }

    order.setStatus(true);

    deliveryService.createDelivery(orderId, order.getCustomerAddress());
    

    return ordersRepository.save(order);
}

}
