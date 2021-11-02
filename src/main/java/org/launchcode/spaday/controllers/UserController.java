package org.launchcode.spaday.controllers;


import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (verify.equals(user.getPassword())) {
            UserData.add(user);
            List<User> users = UserData.getAll();
            Collections.sort(users);
            model.addAttribute("users", "users");
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords don't match");
            return "user/add";
        }
    }
    @GetMapping("/profile")
    public String displayProfile(Model model, @RequestParam String user, @RequestParam String email) {
        model.addAttribute("user", user);
        model.addAttribute("email", email);
        return "user/profile";
    }
}
