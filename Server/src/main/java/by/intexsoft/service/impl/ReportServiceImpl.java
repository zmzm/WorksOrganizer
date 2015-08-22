package by.intexsoft.service.impl;

import by.intexsoft.model.Report;
import by.intexsoft.repository.ReportRepository;
import by.intexsoft.service.ReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportRepository reportRepository;

    @Override
    @Transactional
    public void create(Report report) {
        reportRepository.save(report);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Report r = reportRepository.findOne(id);
        reportRepository.delete(r);
    }

    @Override
    @Transactional
    public List<Report> findAll() {
        List<Report> reports = null;
        reports = reportRepository.findAll();
        return reports;
    }

    @Override
    @Transactional
    public void update(Report report) {
        Report r = reportRepository.findOne(report.getId());
        r.setId(report.getId());
        r.setName(report.getName());
        r.setProcess(report.getProcess());
        r.setCategory(report.getCategory());

    }

    @Override
    @Transactional
    public Report findById(int id) {
        Report r = reportRepository.findOne(id);
        return r;
    }
}
