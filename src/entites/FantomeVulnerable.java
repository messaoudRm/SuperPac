package entites;

import java.awt.Color;


public class FantomeVulnerable implements EtatFantome {

	@Override
	public void action(Fantome fant) {
		fant.setCouleur(Color.cyan);
		fant.setVitesse(fant.getVitesse() + 1);
	}
}
