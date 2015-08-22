package by.intexsoft.service.impl;

import by.intexsoft.repository.ProcessRepository;
import by.intexsoft.service.ProcessService;
import by.intexsoft.model.Process;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("processService")
public class ProcessServiceImpl implements ProcessService {
    @Resource
    private ProcessRepository processRepository;

    @Override
    @Transactional
    public void create(Process process) {
        processRepository.save(process);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Process process = processRepository.findOne(id);
        processRepository.delete(process);
    }

    @Override
    @Transactional
    public List<Process> findAll() {
        List<Process> p = null;
        p = processRepository.findAll();
        return p;
    }

    @Override
    @Transactional
    public void update(Process process) {
        Process p = processRepository.findOne(process.getId());
        p.setName(process.getName());
        p.setId(process.getId());
    }

    @Override
    @Transactional
    public Process findById(int id) {
        Process p = processRepository.findOne(id);
        return p;
    }
}
