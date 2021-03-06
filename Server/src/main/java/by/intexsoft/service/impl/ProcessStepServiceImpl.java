package by.intexsoft.service.impl;

import by.intexsoft.model.*;
import by.intexsoft.repository.ProcessStepRepository;
import by.intexsoft.service.ProcessStepService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("processStepService")
public class ProcessStepServiceImpl implements ProcessStepService {
    @Resource
    private ProcessStepRepository processStepRepository;

    @Override
    @Transactional
    public String create(ProcessStep step) {
        processStepRepository.save(step);
        return "create success";
    }

    @Override
    @Transactional
    public String delete(int id) {
        ProcessStep step = processStepRepository.findOne(id);
        processStepRepository.delete(step);
        return "delete success";
    }

    @Override
    @Transactional
    public List<ProcessStep> findAll() {
        List<ProcessStep> p = null;
        p = processStepRepository.findAll();
        return p;
    }

    @Override
    @Transactional
    public String update(ProcessStep step) {
        ProcessStep p = processStepRepository.findOne(step.getId());
        p.setId(step.getId());
        p.setName(step.getName());
        p.setPriority(step.getPriority());
        p.setProcess(step.getProcess());
        p.setStatus(step.getStatus());
        p.setUser(step.getUser());
        return "update success";
    }

    @Override
    @Transactional
    public ProcessStep findById(int id) {
        ProcessStep p = processStepRepository.findOne(id);
        return p;
    }

    @Override
    @Transactional
    public List<ProcessStep> getByProcess(by.intexsoft.model.Process process) {
        return processStepRepository.getStepByProcess(process);
    }
}
