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
    public String create(MetaField field) {
        metaFieldRepository.save(field);
        return "create success";
    }

    @Override
    @Transactional
    public String delete(int id) {
        MetaField f = metaFieldRepository.findOne(id);
        metaFieldRepository.delete(f);
        return "delete success";
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
    public String update(MetaField field) {
        MetaField f = metaFieldRepository.findOne(field.getId());
        f.setId(field.getId());
        f.setType(field.getType());
        f.setValidator(f.getValidator());
        return "update success";
    }

    @Override
    @Transactional
    public MetaField findById(int id) {
        MetaField f = metaFieldRepository.findOne(id);
        return f;
    }
}
