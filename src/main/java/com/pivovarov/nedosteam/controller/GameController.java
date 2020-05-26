package com.pivovarov.nedosteam.controller;

import com.pivovarov.nedosteam.entity.Game;
import com.pivovarov.nedosteam.entity.User;
import com.pivovarov.nedosteam.repository.GameRepository;
import com.pivovarov.nedosteam.repository.UserRepository;
import com.pivovarov.nedosteam.service.GameService;
import com.pivovarov.nedosteam.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("shop")
    public String showAllGames(Model model){
        model.addAttribute("allGames", gameRepository.findAll());
        return "gameMenu";
    }
    @GetMapping("{id}")
    public String profile(@PathVariable("id") String id, Model model) throws Exception {
        Game game = gameService.getGame(Integer.parseInt(id));
        model.addAttribute("game", game);
        return "game";
    }

    @GetMapping("registration")
    public String gameRegistration(Model model) {
        model.addAttribute("game", new Game());
        return "gameRegistration";
    }

    @PostMapping("registration")
    public String postGarage(@ModelAttribute Game game) throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByLogin(auth.getName());
        game.setDevNickname(user.getNickname());
        game.setDevId(user.getId());
        Game savedGame = gameService.saveGame(game);
        return "game";
    }
}
