package com.udemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.course.entities.Category;
import com.udemy.course.entities.Order;
import com.udemy.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
