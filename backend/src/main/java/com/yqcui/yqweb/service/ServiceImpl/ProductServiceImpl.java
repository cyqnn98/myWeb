package com.yqcui.yqweb.service.ServiceImpl;

import com.yqcui.yqweb.entity.Product;
import com.yqcui.yqweb.exception.ResourceNotFoundException;
import com.yqcui.yqweb.repository.ProductRepository;
import com.yqcui.yqweb.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional: spring jpa automatically make its methods all transactional
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    //start with spring4.3, if a class, which is configured as a Spring bean,
    //has only one constructor, the @Autowired constructor can be omitted
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository.getProductByProductId(productId);
//        if(product.isPresent()){
//            return product.get();
//        }else{
//            throw new ResourceNotFoundException("Product", "productId", productId);
//        }
        return product;
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        //check whether product with productId exists in db
        Product existingProduct = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product", "productId", productId)
        );
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void deleteProduct(int productId) {
        //check whether product with productId exists in db
        Product existingProduct = productRepository.findById(productId).orElseThrow(
                ()->new ResourceNotFoundException("Product", "productId", productId)
        );
        productRepository.deleteById(productId);
    }
}
