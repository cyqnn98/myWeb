package com.yqcui.yqweb.repository;

import com.yqcui.yqweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//spring jpa default add @repository and @Transactional annotations,
//so no need to add here
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByProductId(Long productId);
}
