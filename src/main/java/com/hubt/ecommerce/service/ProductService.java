package com.hubt.ecommerce.service;

import com.hubt.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product saveProduct(Product product);
    public Product getProductById(Integer id);
    public Product updateProduct(Product product);
    public String deleteProductById(Integer id);
}
