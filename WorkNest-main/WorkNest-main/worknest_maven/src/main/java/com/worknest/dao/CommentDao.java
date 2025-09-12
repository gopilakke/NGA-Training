package com.worknest.dao;

import com.worknest.model.Comment;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class CommentDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() { return sessionFactory.getCurrentSession(); }

    public void save(Comment c) { currentSession().saveOrUpdate(c); }

    public List<Comment> findByTask(Long taskId) {
        return currentSession()
                .createQuery("from Comment c where c.task.id = :tid order by c.createdAt desc", Comment.class)
                .setParameter("tid", taskId)
                .list();
    }
}
