package com.mess.superpac_api.model.state;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Pacman;

public class PacNormal implements EtatPac {

    @Override
    public void action(Pacman pac) {
        // faire pac normale
        pac.setCouleur(GameConstants.COULEUR_PAC_NORMAL);
        pac.setInvisible(false);
    }

}