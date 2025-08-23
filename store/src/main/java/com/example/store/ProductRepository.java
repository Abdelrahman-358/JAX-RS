package com.example.store;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    public static void addProduct(String name, double price) {
        products.add(new Product(name, price));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Product getProductByName(String name) {
        return products.stream()
                       .filter(product -> product.getName().equalsIgnoreCase(name))
                       .findFirst().orElse(null);
    }

    public static boolean removeProductByName(String name) {
        return products.removeIf(product -> product.getName().equals(name));
    }

    public static void updateProduct(String name, double newPrice) {
        Product product = getProductByName(name);
        if (product != null) {
            product.setPrice(newPrice);
        }
    }
}
