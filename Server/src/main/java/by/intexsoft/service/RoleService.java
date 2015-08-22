package by.intexsoft.service;

import by.intexsoft.model.Role;

import java.util.List;

public interface RoleService {
    public String create(Role role);
    public String delete(int id);
    public List<Role> findAll();
    public String update(Role role);
    public Role findById(int id);
}
