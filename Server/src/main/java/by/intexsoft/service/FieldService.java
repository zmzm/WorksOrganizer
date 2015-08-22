package by.intexsoft.service;

import by.intexsoft.model.Field;

import java.util.List;

public interface FieldService {
    public void create(Field category);
    public void delete(int id);
    public List<Field> findAll();
    public void update(Field category);
    public Field findById(int id);
}
