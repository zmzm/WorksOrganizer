package by.intexsoft.service.impl;

import by.intexsoft.model.Field;
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
    public void create(Field field) {
        fieldRepository.save(field);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Field f = fieldRepository.findOne(id);
        fieldRepository.delete(f);
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
    public void update(Field field) {
        Field f = fieldRepository.findOne(field.getId());
        f.setId(field.getId());
        f.setName(field.getName());
        f.setMeta(field.getMeta());
        f.setStep(field.getStep());
        f.setValue(field.getValue());
    }

    @Override
    @Transactional
    public Field findById(int id) {
        Field f = fieldRepository.findOne(id);
        return f;
    }
}
