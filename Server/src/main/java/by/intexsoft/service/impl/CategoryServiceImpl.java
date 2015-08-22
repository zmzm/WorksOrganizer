package by.intexsoft.service.impl;

import by.intexsoft.model.Category;
import by.intexsoft.repository.CategoryRepository;
import by.intexsoft.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void update(Category category) {
        Category c = categoryRepository.findOne(category.getId());
        c.setCategoryName(category.getCategoryName());
        c.setId(category.getId());
        c.setParentId(category.getParentId());
    }

    @Override
    @Transactional
    public void delete(int id) {
        Category c = categoryRepository.findOne(id);
        categoryRepository.delete(c);
    }

    @Override
    //@Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    //@Transactional
    public Category findById(int id) {
        Category c = categoryRepository.findOne(id);
        return c;
    }
}
