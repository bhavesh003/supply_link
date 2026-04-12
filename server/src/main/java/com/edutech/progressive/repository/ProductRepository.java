package com.edutech.progressive.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
