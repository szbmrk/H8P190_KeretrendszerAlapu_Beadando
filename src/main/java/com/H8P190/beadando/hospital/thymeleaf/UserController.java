package com.H8P190.beadando.hospital.thymeleaf;

import com.H8P190.beadando.hospital.entity.User;
import com.H8P190.beadando.hospital.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("page", "users");
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("page", "users");
        return "edit-user";
    }

    @PostMapping("/edit")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping()
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
