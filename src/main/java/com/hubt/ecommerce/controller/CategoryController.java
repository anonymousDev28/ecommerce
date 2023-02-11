package com.hubt.ecommerce.controller;

import com.hubt.ecommerce.model.Category;
import com.hubt.ecommerce.model.Product;
import com.hubt.ecommerce.repository.CategoryRepository;
import com.hubt.ecommerce.service.CategoryService;
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
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/{id}")
    @RolesAllowed({"ROLE_EDITOR","ROLE_CUSTOMER"})
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Category> saveCategory(@RequestBody @Valid Category category){
        Category savedCategory = categoryService.saveCategory(category);
        URI categoryURI = URI.create("/category/"+savedCategory.getId());
        return ResponseEntity.created(categoryURI).body(savedCategory);
    }
    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_EDITOR")
    public String deleteCategoryById(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }
}
