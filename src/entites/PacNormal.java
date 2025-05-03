package entites;

import java.awt.Color;

public class PacNormal implements EtatPac {

	@Override
	public void action(Pacman pac) {
		// faire pac normale
		pac.couleur = Color.orange;
		pac.invisible = false;
	}

}