package by.intexsoft.service;

import by.intexsoft.model.Field;
import by.intexsoft.model.ProcessStep;

import java.util.List;

public interface FieldService {
    public String create(Field category);
    public String delete(int id);
    public List<Field> findAll();
    public String update(Field category);
    public Field findById(int id);
    public List<Field> getByStep(ProcessStep step);
}
