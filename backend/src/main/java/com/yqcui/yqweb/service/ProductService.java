package com.yqcui.yqweb.service;

import com.yqcui.yqweb.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product updateProduct(Product product, int productId);
    void deleteProduct(int productId);
}
