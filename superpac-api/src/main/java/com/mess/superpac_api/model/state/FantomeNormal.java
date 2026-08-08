package com.mess.superpac_api.model.state;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Fantome;

public class FantomeNormal implements EtatFantome {

    @Override
    public void action(Fantome fant) {
        fant.setCouleur(GameConstants.COULEUR_FANTOME_NORMAL);
        fant.setVitesse(1);
    }
}