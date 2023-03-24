package com.hubt.ecommerce.service;

import com.hubt.ecommerce.domain.dto.CategoryDTO;
import com.hubt.ecommerce.domain.model.Category;
import com.hubt.ecommerce.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }
    public List<CategoryDTO> getCategories(){
        List<Category>  categories = categoryRepository.findAll();
        return categories.stream().map(category -> new ModelMapper().map(category,CategoryDTO.class)).collect(Collectors.toList());
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category updateCategory(Category category){
        if(categoryRepository.findById(category.getId()).isPresent()){
            Category existCategory = categoryRepository.findById(category.getId()).orElse(null);
            existCategory.setCategoryName(category.getCategoryName());
            existCategory.setProducts(category.getProducts());
            categoryRepository.save(existCategory);
            return existCategory;
        }else {
            return null;
        }
    }
    public String deleteCategory(Integer id){
        if(categoryRepository.findById(id).isPresent()){
            categoryRepository.deleteById(id);
            return "deleted category with id: "+id;
        }else {
            return "id "+id+" dont exist";
        }
    }
}
