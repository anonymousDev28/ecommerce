package com.hubt.ecommerce.controller;

import com.hubt.ecommerce.model.Product;
import com.hubt.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
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
    private ProductService productService;
    @GetMapping
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public List<Product> products(){
        return productService.getProducts();
    }
    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> product(@RequestBody @Valid Product product){
        Product savedProduct = productService.saveProduct(product);
        URI productURI = URI.create("/product/"+savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }
    @PutMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> update(@RequestBody @Valid Product product){
        Product updatedProduct = productService.updateProduct(product);
        URI productURI = URI.create("/updateProduct/"+updatedProduct.getId());
        return ResponseEntity.created(productURI).body(updatedProduct);
    }
    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_EDITOR")
    public String delete(@PathVariable @Valid Integer id){
        return productService.deleteProductById(id);
    }
}
