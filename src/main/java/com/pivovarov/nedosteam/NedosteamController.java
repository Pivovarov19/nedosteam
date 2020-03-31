package com.pivovarov.nedosteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NedosteamController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile/{nickname}/{age}/{email}")
    public String profile(@PathVariable("nickname")String nickname,
                          @PathVariable("age")String age,
                          @PathVariable("email")String email,
                          Model model) {
        User user = new User(nickname, Integer.parseInt(age), email);
        User savedUser = profileService.saveUser(user);
        model.addAttribute("nickname", nickname);
        model.addAttribute("age", age);
        model.addAttribute("email", email);
        return "profile";
    }

}
