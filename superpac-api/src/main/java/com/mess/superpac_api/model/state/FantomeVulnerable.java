package com.mess.superpac_api.model.state;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Fantome;

public class FantomeVulnerable implements EtatFantome {

    @Override
    public void action(Fantome fant) {
        fant.setCouleur(GameConstants.COULEUR_FANTOME_VULNERABLE);
        fant.setVitesse(fant.getVitesse() + 1);
    }
}