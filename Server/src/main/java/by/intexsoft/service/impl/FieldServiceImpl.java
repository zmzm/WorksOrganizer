package by.intexsoft.service.impl;

import by.intexsoft.model.Field;
import by.intexsoft.model.ProcessStep;
import by.intexsoft.repository.FieldRepository;
import by.intexsoft.service.FieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("fieldService")
public class FieldServiceImpl implements FieldService {
    @Resource
    private FieldRepository fieldRepository;

    @Override
    @Transactional
    public String create(Field field) {
        fieldRepository.save(field);
        return "create success";
    }

    @Override
    @Transactional
    public String delete(int id) {
        Field f = fieldRepository.findOne(id);
        fieldRepository.delete(f);
        return "delete success";
    }

    @Override
    @Transactional
    public List<Field> findAll() {
        List<Field> fields = null;
        fields = fieldRepository.findAll();
        return fields;
    }

    @Override
    @Transactional
    public String update(Field field) {
        Field f = fieldRepository.findOne(field.getId());
        f.setId(field.getId());
        f.setName(field.getName());
        f.setMeta(field.getMeta());
        f.setStep(field.getStep());
        f.setValue(field.getValue());
        return "update success";
    }

    @Override
    @Transactional
    public Field findById(int id) {
        Field f = fieldRepository.findOne(id);
        return f;
    }

    @Override
    public List<Field> getByStep(ProcessStep step) {
        return fieldRepository.getStepByStep(step);
    }
}
