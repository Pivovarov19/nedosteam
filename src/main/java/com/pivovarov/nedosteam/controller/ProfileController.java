package com.pivovarov.nedosteam.controller;

import com.pivovarov.nedosteam.repository.UserRepository;
import com.pivovarov.nedosteam.service.ProfileService;
import com.pivovarov.nedosteam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserRepository userRepository;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("all")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userRepository.findAll());
        return "userMenu";
    }

    @GetMapping("{id}")
    public String profile(@PathVariable("id") String id, Model model) throws Exception {
        User user = profileService.getUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "profile";
    }

    @PutMapping("{id}")
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

    @GetMapping("login")
    public String login() {return "login";}

    @GetMapping("registration")
    public String registrationProfile(Model model) {
        model.addAttribute("user", new User());
        return "userRegistration";
    }

    @PostMapping("registration")
    public String postGarage(@ModelAttribute User user) {
        User savedUser = profileService.saveUser(user);
        return "redirect:login";
    }
}