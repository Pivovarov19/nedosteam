package com.pivovarov.nedosteam.controller;

import com.pivovarov.nedosteam.service.ProfileService;
import com.pivovarov.nedosteam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NedosteamController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable("id") String id, Model model) throws Exception {
        User user = profileService.getUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile")
    public String postProfile(@RequestBody User user, Model model) {
        User savedUser = profileService.saveUser(user);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/profile/registration")
    public String registrationProfile() {
        return "registration";
    }

    @PutMapping("/profile/{id}")
    public String putProfile(@RequestBody User user, @PathVariable("id") long id, Model model) {
        User currentUser = null;
        try {
            currentUser = profileService.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (currentUser != null) {
            if (user.getAge() != 0) {
                currentUser.setAge(user.getAge());
            }
            if (user.getNickname() != null) {
                currentUser.setNickname(user.getNickname());
            }
            if (user.getEmail() != null) {
                currentUser.setEmail(user.getEmail());
            }
        }
        User savedUser = profileService.saveUser(currentUser);
        model.addAttribute("user", currentUser);
        return "profile";
    }
}
