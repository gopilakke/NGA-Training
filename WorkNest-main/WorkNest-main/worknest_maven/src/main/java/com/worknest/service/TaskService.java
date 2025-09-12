package com.worknest.service;

import com.worknest.dao.TaskDao;
import com.worknest.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired private TaskDao taskDao;

    public void save(Task t) { taskDao.save(t); }
    public Task find(Long id) { return taskDao.findById(id); }
    public List<Task> all() { return taskDao.findAll(); }
    public List<Task> byAssignee(Long uid) { return taskDao.findByAssignee(uid); }
    public List<Task> byStatus(TaskStatus status) { return taskDao.findByStatus(status); }
    public void delete(Long id) { taskDao.delete(id); }
}
