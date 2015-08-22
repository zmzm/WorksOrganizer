package by.intexsoft.service;

import by.intexsoft.model.Process;

import java.util.List;

public interface ProcessService {
    public void create(Process category);
    public void delete(int id);
    public List<Process> findAll();
    public void update(Process category);
    public Process findById(int id);
}
