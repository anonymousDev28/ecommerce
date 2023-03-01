package com.hubt.ecommerce.controller;

import com.hubt.ecommerce.domain.model.Product;
import com.hubt.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @GetMapping
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public List<Product> getProducts(){
        return productServiceImpl.getProducts();
    }
    @GetMapping("/{id}")
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public Product getProductByID(@PathVariable Integer id){
        return productServiceImpl.getProductById(id);
    }
    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        Product savedProduct = productServiceImpl.saveProduct(product);
        URI productURI = URI.create("/product/"+savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }
    @PutMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product){
        Product updatedProduct = productServiceImpl.updateProduct(product);
        URI productURI = URI.create("/updateProduct/"+updatedProduct.getId());
        return ResponseEntity.created(productURI).body(updatedProduct);
    }
    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_EDITOR")
    public String deleteProduct(@PathVariable @Valid Integer id){
        return productServiceImpl.deleteProductById(id);
    }
}
