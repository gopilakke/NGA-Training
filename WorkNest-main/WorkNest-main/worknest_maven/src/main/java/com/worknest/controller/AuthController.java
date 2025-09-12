package com.worknest.controller;

import com.worknest.model.User;
import com.worknest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired private UserService userService;

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password,
                          HttpSession session, Model model) {
        User u = userService.findByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            session.setAttribute("currentUserId", u.getId());
            session.setAttribute("currentRole", u.getRole());
            return "ADMIN".equals(u.getRole()) ? "redirect:/admin/dashboard" : "redirect:/user/dashboard";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) { model.addAttribute("user", new User()); return "register"; }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute User user, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        if (user.getRole() == null) user.setRole("USER");
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
