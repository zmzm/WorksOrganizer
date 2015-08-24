package by.intexsoft.service;

import by.intexsoft.model.User;

import java.util.List;

public interface UserService {
    public String create(User user);
    public String delete(int id);
    public List<User> findAll();
    public String update(User user);
    public User findById(int id);
    public User findByName(String name);
}
