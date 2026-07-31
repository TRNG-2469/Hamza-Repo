package com.rev.jdbc.dao;

import com.rev.jdbc.model.Product;

import java.util.List;

public interface ProductDAO {
    // CRUD

    void create(Product product);
    void update(Product product);
    void delete(int id);

    // Read All, Read One
    Product findById(int id);
    List<Product> findAll();

    void updateProduct(Product product);
}