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
    public Product getProductById(Integer id){
        return productRepository.findById(id).orElse(null);
    }
    public Product updateProduct(Product product){
        Product existProduct = getProductById(product.getId());
        if(existProduct!=null){
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            productRepository.save(existProduct);
            return existProduct;
        }else{
            return null;
        }
    }
    public String deleteProductById(Integer id){
        if(productRepository.findById(id)!=null){
            productRepository.deleteById(id);
            return "deleted Product have id: "+id;
        }else {
            return "id invalid or dont exist";
        }
    }
}
