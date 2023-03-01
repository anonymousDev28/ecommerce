package com.hubt.ecommerce.service;

import com.hubt.ecommerce.domain.model.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategoryById(Integer id);
    public List<Category> getCategories();
    public Category saveCategory(Category category);
    public Category updateCategory(Category category);
    public String deleteCategory(Integer id);
}
