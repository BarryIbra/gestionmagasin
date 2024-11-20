package com.barryibrahima.gestionmagasin.execptions;

public class CustomerNotFoundException extends  RuntimeException {

    public CustomerNotFoundException(String message) {
        
        super(message,new Throwable("Utilisateur introuvable"));
    }

}
