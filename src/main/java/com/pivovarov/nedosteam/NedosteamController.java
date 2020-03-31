package com.pivovarov.nedosteam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NedosteamController {

    @GetMapping("/profile/{login}")
    public String profile(@RequestParam("login")String login, Model model) {
        model.addAttribute("login", login);
        return "profile";
    }

}