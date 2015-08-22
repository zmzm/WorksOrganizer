package by.intexsoft.service;

import by.intexsoft.model.ProcessStep;

import java.util.List;

public interface ProcessStepService {
    public String create(ProcessStep category);
    public String delete(int id);
    public List<ProcessStep> findAll();
    public String update(ProcessStep category);
    public ProcessStep findById(int id);
}
