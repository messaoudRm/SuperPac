package com.mess.superpac_api.controller;

import com.mess.superpac_api.service.GameLoopService;
import com.mess.superpac_api.service.GameService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


@Controller
public class GameController {

    private final GameService gameService;
    private final GameLoopService gameLoopService;

    public GameController(GameService gameService, GameLoopService gameLoopService) {
        this.gameService = gameService;
        this.gameLoopService = gameLoopService;
    }

    @MessageMapping("/input")
    public void handleInput(String input) {
        gameService.handleInput(input);
    }

    @MessageMapping("/restart")
    public void restartGame() {
        gameService.restartGame();
        gameLoopService.demarrer();
    }
}