package by.intexsoft.service;

import by.intexsoft.model.Process;

import java.util.List;

public interface ProcessService {
    public String create(Process category);
    public String delete(int id);
    public List<Process> findAll();
    public String update(Process category);
    public Process findById(int id);
}
