package org.rado.app.service;

import org.rado.app.db.entity.Product;
import org.rado.app.db.finder.ProductFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductFinder productFinder;

    public List<Product> getAllProducts() {
        return this.productFinder.findAll();
    }

    public Product getProductById(String id) {
        return this.productFinder.findById(id);
    }
}
