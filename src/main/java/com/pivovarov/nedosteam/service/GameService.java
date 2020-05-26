package com.pivovarov.nedosteam.service;

import com.pivovarov.nedosteam.entity.Game;
import com.pivovarov.nedosteam.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game getGame(long id) throws Exception {
        Optional<Game> byId = gameRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new Exception("Game isn't exist!");
    }

    public void deleteGame(long id) {
        gameRepository.deleteById(id);
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }
}
