package com.rev.jdbc.model;

import com.rev.jdbc.dao.ProductDAO;
import com.rev.jdbc.dao.ProductDAOImpl;

import java.util.List;

public class ProductServiceImpl implements ProductDAO {
    @Override
    public void create(Product product) {

    }

    public void update(Product product) {
        ProductDAO productDAO = new ProductDAOImpl();
        //Implementing business logic here and validating the product
        //check for nulls or negative values
        if (product == null || product.getName() == null || product.getPrice() < 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        //Implementing business logic here and validating the product
        //check for nulls or negative values
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }
        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.delete(id);
    }

    @Override
    public Product findById(int id) {
        //Implementing business logic here and validating the product
        //check for nulls or negative values
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID");
        }
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        ProductDAO productDAO = new ProductDAOImpl();
        return productDAO.findAll();
    }

    @Override
    public void updateProduct(Product product) {

    }
}
