package by.intexsoft.service;

import by.intexsoft.model.Category;

import java.util.List;

public interface CategoryService {
    public String create(Category category);
    public String delete(int id);
    public List<Category> findAll();
    public String update(Category category);
    public Category findById(int id);
}