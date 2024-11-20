package com.barryibrahima.gestionmagasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barryibrahima.gestionmagasin.entities.Category;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
