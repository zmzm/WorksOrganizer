package by.intexsoft.service;

import by.intexsoft.model.MetaField;

import java.util.List;

public interface MetaFieldService {
    public String create(MetaField category);
    public String delete(int id);
    public List<MetaField> findAll();
    public String update(MetaField category);
    public MetaField findById(int id);
}
