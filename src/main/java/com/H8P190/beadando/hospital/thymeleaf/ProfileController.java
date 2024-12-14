package com.H8P190.beadando.hospital.thymeleaf;

import com.H8P190.beadando.hospital.service.UserService;
import com.H8P190.beadando.hospital.security.CustomUserDetails;
import com.H8P190.beadando.hospital.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showProfilePage(Model model) {
        model.addAttribute("page", "profile");
        return "profile";
    }

    @PostMapping("/change-password")
    public String changePassword(@RequestParam String newPassword, @RequestParam String confirmPassword, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "profile";
        }

        user.setPassword(newPassword);
        userService.save(user);

        model.addAttribute("message", "Password successfully updated!");
        return "profile";
    }
}
