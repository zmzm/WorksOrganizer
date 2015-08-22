package by.intexsoft.service;

import by.intexsoft.model.User;

import java.util.List;

public interface UserService {
    public void create(User user);
    public void delete(int id);
    public List<User> findAll();
    public void update(User user);
    public User findById(int id);
}
