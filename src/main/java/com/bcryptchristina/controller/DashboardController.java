package com.bcryptchristina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bcryptchristina.model.User; // Import User class
import com.bcryptchristina.repository.UserRepository; // Import UserRepository

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(name = "search", required = false) String search,
            Pageable pageable, Model model) {

        Page<User> users;

        if (search != null && !search.isEmpty()) {
            users = userRepository.findByUsernameContainingIgnoreCase(search, pageable);
        } else {
            users = userRepository.findAll(pageable);
        }

        model.addAttribute("users", users);
        return "dashboard";
    }
}
