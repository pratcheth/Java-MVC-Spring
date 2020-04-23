package org.rado.app.db.finder;

import org.rado.app.db.entity.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ProductFinder {

    private List<Product> products;

    public ProductFinder() {
        this.seedData();
    }

    public List<Product> findAll() {
        return this.products;
    }

    public Product findById(String id) {
        return this.products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Product findByName(String productName) {
        return this.products.stream().filter(p -> p.getName().equals(productName)).findFirst().orElse(null);
    }

    private void seedData() {
        this.products = new ArrayList<>();
        this.products.add(new Product("ba87b686-4ab6-4c09-8c81-8e2f9d14c96c", "Product 1", "", this.generateRandomPrice()));
        this.products.add(new Product("dc3ac1f2-1a96-4c3a-8c30-92655bacbcbb", "Product 2", "", this.generateRandomPrice()));
        this.products.add(new Product("69ee05fb-d68a-4545-b38b-c2795e944bb7", "Product 3", "", this.generateRandomPrice()));
        this.products.add(new Product("057dd619-be03-41ec-9a34-d3ab0ee5f9a9", "Product 4", "", this.generateRandomPrice()));
        this.products.add(new Product("2adc757f-c3c1-414e-9ef0-5be1f62d7e92", "Product 5", "", this.generateRandomPrice()));
    }

    private BigDecimal generateRandomPrice() {
        Random rnd = new Random();
        double rndDouble = (double) rnd.nextInt() / 10f;

        if (rndDouble < 0) {
            return new BigDecimal(rndDouble * -1);
        }

        return new BigDecimal(rndDouble);
    }
}
