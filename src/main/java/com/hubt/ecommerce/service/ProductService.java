package com.hubt.ecommerce.service;

import com.hubt.ecommerce.model.Product;
import com.hubt.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
