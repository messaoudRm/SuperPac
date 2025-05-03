package entites;

import java.awt.Color;


import entites.EtatPac;
import entites.Pacman;
import jeu.Controleur;
import ressources.Chrono;

public class SuperPac implements EtatPac {

	@Override
	public void action(Pacman pac) {
		//faire un super pac
		//Fantome.setCouleur(Color.cyan);
		pac.invisible = true;
		pac.setCouleur(Color.yellow);
		if (Chrono.bouleActive <= 20) { //boule active pendant 10sec --> 10 000ms
			if(pac.getxPos() == Controleur.f1.getxPos() && pac.getyPos() == Controleur.f1.getyPos()){
				Controleur.f1.fantMort();
			}
			if(pac.getxPos() == Controleur.f2.getxPos() && pac.getyPos() == Controleur.f2.getyPos()) {
				Controleur.f2.fantMort();
			}	
			if(pac.getxPos() == Controleur.f3.getxPos() && pac.getyPos() == Controleur.f3.getyPos()) {
				Controleur.f3.fantMort();
			}
			if(pac.getxPos() == Controleur.f4.getxPos() && pac.getyPos() == Controleur.f4.getyPos()){
				Controleur.f4.fantMort();
			}
		}else {
			PommeOrange.setActive(false);
			Controleur.bouleActive = 3;
		}
	}
}
