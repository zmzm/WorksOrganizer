package by.intexsoft.service;

import by.intexsoft.model.ProcessStep;

import java.util.List;

public interface ProcessStepService {
    public void create(ProcessStep category);
    public void delete(int id);
    public List<ProcessStep> findAll();
    public void update(ProcessStep category);
    public ProcessStep findById(int id);
}
