package by.intexsoft.service.impl;

import by.intexsoft.model.User;
import by.intexsoft.repository.UserRepository;
import by.intexsoft.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User u = userRepository.findOne(id);
        userRepository.delete(u);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        List<User> users = null;
        users = userRepository.findAll();
        return users;
    }

    @Override
    @Transactional
    public void update(User user) {
        User u = userRepository.findOne(user.getId());
        u.setId(user.getId());
        u.setRoleId(user.getRoleId());
        user.setUserName(user.getUserName());
        user.setUserPassword(user.getUserPassword());

    }

    @Override
    @Transactional
    public User findById(int id) {
        User u = userRepository.findOne(id);
        return u;
    }
}