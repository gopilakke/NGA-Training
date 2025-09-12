package com.worknest.dao;

import com.worknest.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class TaskDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() { return sessionFactory.getCurrentSession(); }

    public void save(Task t) { currentSession().saveOrUpdate(t); }

    public Task findById(Long id) { return currentSession().get(Task.class, id); }

    public List<Task> findAll() { return currentSession().createQuery("from Task", Task.class).list(); }

    public List<Task> findByAssignee(Long userId) {
        return currentSession()
                .createQuery("from Task t where t.assignedTo.id = :uid", Task.class)
                .setParameter("uid", userId)
                .list();
    }

    public List<Task> findByStatus(TaskStatus status) {
        return currentSession()
                .createQuery("from Task t where t.status = :s", Task.class)
                .setParameter("s", status)
                .list();
    }

    public void delete(Long id) {
        Task t = findById(id);
        if (t != null) currentSession().delete(t);
    }
}
