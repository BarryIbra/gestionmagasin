package com.barryibrahima.gestionmagasin.execptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProduitNotFoundExecption.class)
    protected ResponseEntity<Object> handleProduitNotFoundException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, "Cet Produit n'a pas été trouvé", new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(ProduitIndisponibleException.class)
    protected ResponseEntity<Object> handleProduitIndisponibleException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.PRECONDITION_FAILED,
                request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleCustomerNotFoundException(Exception e, WebRequest request) {
        return handleExceptionInternal(e, "Cet Utilisateur n'a pas été trouvé", new HttpHeaders(), HttpStatus.NOT_FOUND,
                request);
    }

}
