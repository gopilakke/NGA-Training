package com.worknest.service;

import com.worknest.dao.UserDao;
import com.worknest.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired private UserDao userDao;

    public void register(User u) { userDao.save(u); }
    public User findByUsername(String username) { return userDao.findByUsername(username); }
    public List<User> allUsers() { return userDao.findAll(); }
    public void delete(Long id) { userDao.delete(id); }
    public User find(Long id) { return userDao.findById(id); }
}
