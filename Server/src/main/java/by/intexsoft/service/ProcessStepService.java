package by.intexsoft.service;

import by.intexsoft.model.*;

import java.util.List;

public interface ProcessStepService {
    public String create(ProcessStep category);
    public String delete(int id);
    public List<ProcessStep> findAll();
    public String update(ProcessStep category);
    public ProcessStep findById(int id);
    public ProcessStep getByProcess(by.intexsoft.model.Process process);
}
