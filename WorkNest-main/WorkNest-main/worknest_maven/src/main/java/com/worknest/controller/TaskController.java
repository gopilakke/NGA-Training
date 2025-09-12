package com.worknest.controller;

import com.worknest.model.*;
import com.worknest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired private TaskService taskService;
    @Autowired private CommentService commentService;
    @Autowired private UserService userService;

    private Long me(HttpSession s) { return (Long) s.getAttribute("currentUserId"); }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model m, HttpSession s) {
        if (me(s) == null) return "redirect:/login";
        Task t = taskService.find(id);
        m.addAttribute("task", t);
        m.addAttribute("comments", commentService.forTask(id));
        return "task-view";
    }

    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status, HttpSession s) {
        Long uid = me(s);
        if (uid == null) return "redirect:/login";
        Task t = taskService.find(id);
        if (t != null && t.getAssignedTo() != null && t.getAssignedTo().getId().equals(uid)) {
            t.setStatus(TaskStatus.valueOf(status));
            taskService.save(t);
        }
        return "redirect:/tasks/" + id;
    }
}
