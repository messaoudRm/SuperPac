package com.mess.superpac_api.service;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Pacman;
import org.springframework.stereotype.Service;

@Service
public class ClavierService {

    public void keyTyped(String input, Pacman pacman) {
        if (input.equals("d")) {
            pacman.setDy(GameConstants.DEPLACEMENT_Y_TAB);
            GameConstants.sens = 1;
        }
        if (input.equals("q")) {
            pacman.setDy(- GameConstants.DEPLACEMENT_Y_TAB);
            GameConstants.sens = 2;
        }
        if (input.equals("z")) {
            pacman.setDx(- GameConstants.DEPLACEMENT_X_TAB);
            GameConstants.sens = 3;
        }
        if (input.equals("s")) {
            pacman.setDx(GameConstants.DEPLACEMENT_X_TAB);
            GameConstants.sens = 4;
        }
    }
}
