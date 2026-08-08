package com.mess.superpac_api.model.state;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Pacman;
import com.mess.superpac_api.model.entity.PommeOrange;
import com.mess.superpac_api.service.GameService;

public class SuperPac implements EtatPac {

    private final GameService gameService;

    public SuperPac(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void action(Pacman pac) {
        // faire un super pac
        pac.setInvisible(true);
        pac.setCouleur(GameConstants.COULEUR_PAC_SUPER);
        if (gameService.getCompteurPouvoirActif() <= 20) { // boule active pendant 10sec --> 10 000ms
            if (pac.getxPos() == gameService.getF1().getxPos() && pac.getyPos() == gameService.getF1().getyPos()) {
                gameService.getF1().fantMort();
            }
            if (pac.getxPos() == gameService.getF2().getxPos() && pac.getyPos() == gameService.getF2().getyPos()) {
                gameService.getF2().fantMort();
            }
            if (pac.getxPos() == gameService.getF3().getxPos() && pac.getyPos() == gameService.getF3().getyPos()) {
                gameService.getF3().fantMort();
            }
            if (pac.getxPos() == gameService.getF4().getxPos() && pac.getyPos() == gameService.getF4().getyPos()) {
                gameService.getF4().fantMort();
            }
        } else {
            PommeOrange.setActive(false);
            gameService.setBouleActive(3);
        }
    }
}
