package com.hubt.ecommerce.controller;

import com.hubt.ecommerce.domain.model.Category;
import com.hubt.ecommerce.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public List<Category> getCategories(){
        return categoryServiceImpl.getCategories();
    }
    @GetMapping("/{id}")
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public Category getCategoryById(@PathVariable Integer id){
        return categoryServiceImpl.getCategoryById(id);
    }
    @PutMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category updatedCategory = categoryServiceImpl.updateCategory(category);
        URI categoryURI = URI.create("/category/"+updatedCategory.getId());
        return ResponseEntity.created(categoryURI).body(updatedCategory);
    }
    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Category> saveCategory(@RequestBody @Valid Category category){
        Category savedCategory = categoryServiceImpl.saveCategory(category);
        URI categoryURI = URI.create("/category/"+savedCategory.getId());
        return ResponseEntity.created(categoryURI).body(savedCategory);
    }
    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_EDITOR")
    public String deleteCategoryById(@PathVariable Integer id){
        return categoryServiceImpl.deleteCategory(id);
    }
}
