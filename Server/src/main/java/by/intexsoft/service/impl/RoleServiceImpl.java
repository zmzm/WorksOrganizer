package by.intexsoft.service.impl;

import by.intexsoft.model.Role;
import by.intexsoft.repository.RoleRepository;
import by.intexsoft.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Role r = roleRepository.findOne(id);
        roleRepository.delete(r);
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        List<Role> roles = null;
        roles = roleRepository.findAll();
        return roles;
    }

    @Override
    @Transactional
    public void update(Role role) {
        Role r = roleRepository.findOne(role.getId());
        r.setId(role.getId());
        r.setRoleName(role.getRoleName());
    }

    @Override
    @Transactional
    public Role findById(int id) {
        Role r = roleRepository.findOne(id);
        return r;
    }
}
