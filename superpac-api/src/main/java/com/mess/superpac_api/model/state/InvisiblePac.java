package com.mess.superpac_api.model.state;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Pacman;
import com.mess.superpac_api.model.entity.PommeViolette;
import com.mess.superpac_api.service.GameService;

public class InvisiblePac implements EtatPac {

    private final GameService gameService;

    public InvisiblePac(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void action(Pacman pac) {
        // pacman invisible
        if (gameService.getCompteurPouvoirActif() <= 20) { // boule active pendant 4sec
            pac.setInvisible(true);
            pac.setCouleur(GameConstants.COULEUR_PAC_INVISIBLE);
        } else {
            PommeViolette.setActive(false);
            gameService.setBouleActive(3);
        }
    }
}
