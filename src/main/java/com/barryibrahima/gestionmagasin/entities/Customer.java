package com.barryibrahima.gestionmagasin.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Customer implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String adresse;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    


    public Customer() {
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getEmail() {
        return email;
    }


    public Role getRole() {
        return role;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public List<Orders> getOrders() {
        return orders;
    }


    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

       SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+role.getName().toString());
        return List.of(authority);
    }


    @Override
    public String getPassword() {
        
        return password;
    }


    @Override
    public String getUsername() {
        
        return email;
    }
    

}
