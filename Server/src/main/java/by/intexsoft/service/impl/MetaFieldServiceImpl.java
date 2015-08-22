package by.intexsoft.service.impl;

import by.intexsoft.model.MetaField;
import by.intexsoft.repository.MetaFieldRepository;
import by.intexsoft.service.MetaFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("metaFieldService")
public class MetaFieldServiceImpl implements MetaFieldService {
    @Resource
    private MetaFieldRepository metaFieldRepository;

    @Override
    @Transactional
    public void create(MetaField field) {
        metaFieldRepository.save(field);
    }

    @Override
    @Transactional
    public void delete(int id) {
        MetaField f = metaFieldRepository.findOne(id);
        metaFieldRepository.delete(f);
    }

    @Override
    @Transactional
    public List<MetaField> findAll() {
        List<MetaField> fields = null;
        fields = metaFieldRepository.findAll();
        return fields;
    }

    @Override
    @Transactional
    public void update(MetaField field) {
        MetaField f = metaFieldRepository.findOne(field.getId());
        f.setId(field.getId());
        f.setType(field.getType());
        f.setValidator(f.getValidator());
    }

    @Override
    @Transactional
    public MetaField findById(int id) {
        MetaField f = metaFieldRepository.findOne(id);
        return f;
    }
}
