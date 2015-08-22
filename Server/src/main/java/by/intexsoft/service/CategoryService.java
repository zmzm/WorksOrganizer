package by.intexsoft.service;

import by.intexsoft.model.Category;

import java.util.List;

public interface CategoryService {
    public void create(Category category);
    public void delete(int id);
    public List<Category> findAll();
    public void update(Category category);
    public Category findById(int id);
}