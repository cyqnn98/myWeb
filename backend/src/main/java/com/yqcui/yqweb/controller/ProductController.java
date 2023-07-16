package com.yqcui.yqweb.controller;

import com.yqcui.yqweb.entity.Product;
import com.yqcui.yqweb.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //combines @Controller and @ResponseBody
@RequestMapping("/api/products")
//@CrossOrigin
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //build create Product REST API
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    //build get all products REST API
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //build getProductById REST API
    @GetMapping("{productId}")
    public Product getProductById(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }

    //build update product REST API
    @PutMapping("{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") int productId){
        return new ResponseEntity<>(productService.updateProduct(product, productId), HttpStatus.OK);
    }

    //build delete product REST API
    @DeleteMapping("{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
