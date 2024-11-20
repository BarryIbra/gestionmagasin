package com.barryibrahima.gestionmagasin.execptions;

public class ProduitIndisponibleException extends RuntimeException {

    public ProduitIndisponibleException(String message) {
        super(message);
    }

}
