package com.worknest.controller;

import com.worknest.model.*;
import com.worknest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired private CommentService commentService;
    @Autowired private TaskService taskService;
    @Autowired private UserService userService;

    private Long me(HttpSession s) { return (Long) s.getAttribute("currentUserId"); }

    @PostMapping("/add")
    public String add(@RequestParam Long taskId, @RequestParam String text, HttpSession s) {
        Long uid = me(s);
        if (uid == null) return "redirect:/login";
        Task t = taskService.find(taskId);
        if (t == null) return "redirect:/user/dashboard";
        Comment c = new Comment();
        c.setTask(t);
        c.setUser(userService.find(uid));
        c.setText(text);
        commentService.add(c);
        return "redirect:/tasks/" + taskId;
    }
}
