package com.mess.superpac_api.service;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.GameState;
import com.mess.superpac_api.model.enums.GameStatus;
import org.springframework.stereotype.Component;

@Component
public class GameLoopService implements Runnable {

    private final GameService gameService;
    private final BroadcastService broadcastService;

    private boolean actif = false;

    public GameLoopService(GameService gameService, BroadcastService broadcastService) {
        this.gameService = gameService;
        this.broadcastService = broadcastService;
    }

    public synchronized void demarrer() {
        if (actif) {
            return;
        }
        actif = true;
        new Thread(this).start();
    }

    public synchronized void arreter() {
        actif = false;
    }

    @Override
    public void run() {
        while (actif) {
            gameService.mettreAJourEtat();
            GameState state = gameService.getState();
            broadcastService.diffuser(state);

            if (state.getStatut() == GameStatus.GAME_OVER) {
                actif = false;
                break;
            }

            try {
                Thread.sleep(GameConstants.INTERVALLE_TICK_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}