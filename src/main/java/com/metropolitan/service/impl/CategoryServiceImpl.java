package com.metropolitan.service.impl;


import com.metropolitan.model.quiz.Category;
import com.metropolitan.repository.CategoryRepository;
import com.metropolitan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long cid) {
        return categoryRepository.findById(cid).get();
    }

    @Override
    public void deleteCategory(Long cid) {
        categoryRepository.deleteById(cid);
    }
}
