package com.worknest.dao;

import com.worknest.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() { return sessionFactory.getCurrentSession(); }

    public void save(User u) { currentSession().saveOrUpdate(u); }

    public User findById(Long id) { return currentSession().get(User.class, id); }

    public User findByUsername(String username) {
        return currentSession()
                .createQuery("from User where username = :u", User.class)
                .setParameter("u", username)
                .uniqueResultOptional()
                .orElse(null);
    }

    public List<User> findAll() {
        return currentSession().createQuery("from User", User.class).list();
    }

    public void delete(Long id) {
        User u = findById(id);
        if (u != null) currentSession().delete(u);
    }
}
