package by.intexsoft.service;

import by.intexsoft.model.MetaField;

import java.util.List;

public interface MetaFieldService {
    public void create(MetaField category);
    public void delete(int id);
    public List<MetaField> findAll();
    public void update(MetaField category);
    public MetaField findById(int id);
}
