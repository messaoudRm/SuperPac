package entites;

import java.awt.Color;

import jeu.Controleur;
import ressources.Chrono;

public class InvisiblePac implements EtatPac {

	@Override
	public void action(Pacman pac) {
		//pacman invisible 
			if(Chrono.bouleActive <= 20) { //boule active pendant 4sec
				pac.setInvisible(true);
				pac.setCouleur(Color.magenta);
			}
			else {
				PommeViolet.setActive(false);
				Controleur.bouleActive = 3;
			}
		}
}