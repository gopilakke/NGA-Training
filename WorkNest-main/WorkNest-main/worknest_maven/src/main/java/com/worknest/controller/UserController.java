package com.worknest.controller;

import com.worknest.model.*;
import com.worknest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private TaskService taskService;
    @Autowired private UserService userService;

    private Long me(HttpSession s) { return (Long) s.getAttribute("currentUserId"); }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession s, Model m) {
        Long uid = me(s);
        if (uid == null) return "redirect:/login";
        m.addAttribute("tasks", taskService.byAssignee(uid));
        return "user-dashboard";
    }
}
