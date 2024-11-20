package com.barryibrahima.gestionmagasin.execptions;

public class ProduitNotFoundExecption extends RuntimeException {

    public ProduitNotFoundExecption(String message) {
        
        super(message,new Throwable("Produit introuvable"));
    }

    

}
