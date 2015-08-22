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
    public String create(Category category) {
        categoryRepository.save(category);
        return "create success";
    }

    @Override
    @Transactional
    public String update(Category category) {
        Category c = categoryRepository.findOne(category.getId());
        c.setCategoryName(category.getCategoryName());
        c.setId(category.getId());
        c.setParentId(category.getParentId());
        return "update success";
    }

    @Override
    @Transactional
    public String delete(int id) {
        Category c = categoryRepository.findOne(id);
        categoryRepository.delete(c);
        return "delete success";
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category findById(int id) {
        Category c = categoryRepository.findOne(id);
        return c;
    }
}
