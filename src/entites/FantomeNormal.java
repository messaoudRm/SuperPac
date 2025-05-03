package entites;

import java.awt.Color;


public class FantomeNormal implements EtatFantome {

	@Override
	public void action(Fantome fant) {
		fant.setCouleur(Color.red);
		fant.setVitesse(1);
	}
}
