package by.intexsoft.service;

import by.intexsoft.model.Report;

import java.util.List;

public interface ReportService {
    public void create(Report report);
    public void delete(int id);
    public List<Report> findAll();
    public void update(Report report);
    public Report findById(int id);
}
