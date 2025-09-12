package com.worknest.controller;

import com.worknest.model.*;
import com.worknest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired private UserService userService;
    @Autowired private TaskService taskService;

    private boolean ensureAdmin(HttpSession s) { return "ADMIN".equals(s.getAttribute("currentRole")); }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession s, Model model) {
        if (!ensureAdmin(s)) return "redirect:/login";

        List<Task> all = taskService.all();
        model.addAttribute("pending", filter(all, TaskStatus.PENDING));
        model.addAttribute("inprogress", filter(all, TaskStatus.IN_PROGRESS));
        model.addAttribute("completed", filter(all, TaskStatus.COMPLETED));
        model.addAttribute("delayed", filter(all, TaskStatus.DELAYED));
        return "admin-dashboard";
    }

    private List<Task> filter(List<Task> all, TaskStatus st) {
        List<Task> out = new ArrayList<>();
        for (Task t : all) if (t.getStatus() == st) out.add(t);
        return out;
    }

    @GetMapping("/users")
    public String users(Model m, HttpSession s) {
        if (!ensureAdmin(s)) return "redirect:/login";
        m.addAttribute("users", userService.allUsers());
        return "admin-users";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, HttpSession s) {
        if (!ensureAdmin(s)) return "redirect:/login";
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/tasks/new")
    public String newTask(Model m, HttpSession s) {
        if (!ensureAdmin(s)) return "redirect:/login";
        m.addAttribute("task", new Task());
        m.addAttribute("users", userService.allUsers());
        return "task-form";
    }

    @PostMapping("/tasks")
    public String createTask(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String startDate,
                             @RequestParam String dueDate,
                             @RequestParam Long assignedTo,
                             HttpSession s) {
        if (!ensureAdmin(s)) return "redirect:/login";
        Task t = new Task();
        t.setTitle(title);
        t.setDescription(description);
        t.setStartDate(LocalDate.parse(startDate));
        t.setDueDate(LocalDate.parse(dueDate));
        t.setStatus(TaskStatus.PENDING);
        t.setAssignedTo(userService.find(assignedTo));
        Long creatorId = (Long) s.getAttribute("currentUserId");
        if (creatorId != null) t.setCreatedBy(userService.find(creatorId));
        taskService.save(t);
        return "redirect:/admin/dashboard";
    }
}
