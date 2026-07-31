package com.rev.jdbc;

import com.rev.jdbc.dao.ProductDAO;
import com.rev.jdbc.dao.ProductDAOImpl;
import com.rev.jdbc.model.Product;
import com.rev.jdbc.model.ProductServiceImpl;

public class MainClass {
    public static void main(String[] args) {

        // Main --> Service --> DAO --> Database


//        ProductDAO productDAO = new ProductDAOImpl();
//        Product product = new Product(5, "WiFi", 250);
//        productDAO.updateProduct(product);

        Product product = new Product(5, "", -111);
        ProductServiceImpl service = new ProductServiceImpl();
        service.update(product);
    }
}