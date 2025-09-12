package com.worknest.service;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired private CommentDao commentDao;

    public void add(Comment c) { commentDao.save(c); }
    public List<Comment> forTask(Long taskId) { return commentDao.findByTask(taskId); }
}
