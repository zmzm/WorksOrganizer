package by.intexsoft.service;

import by.intexsoft.model.Category;
import by.intexsoft.model.Report;

import java.util.List;

public interface ReportService {
    public String create(Report report);
    public String delete(int id);
    public List<Report> findAll();
    public String update(Report report);
    public Report findById(int id);
    public Report findByCategory(Category category);
}
