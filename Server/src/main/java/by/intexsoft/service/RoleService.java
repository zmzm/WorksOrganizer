package by.intexsoft.service;

import by.intexsoft.model.Role;

import java.util.List;

public interface RoleService {
    public void create(Role role);
    public void delete(int id);
    public List<Role> findAll();
    public void update(Role role);
    public Role findById(int id);
}
