package com.H8P190.beadando.hospital.security;

import com.H8P190.beadando.hospital.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String role = authentication.getAuthorities().toString();
            role = role.replaceAll("ROLE_", "");
            role = role.substring(1, role.length() - 1);
            model.addAttribute("role", role);
            Object principal = authentication.getPrincipal();
            if (principal instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) principal;
                User user = userDetails.getUser();
                model.addAttribute("user", user);
            }
        }
    }
}
