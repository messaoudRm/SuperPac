package ressources;

import entites.PommeOrange;
import entites.PommeViolet;
import jeu.App;
import jeu.Controleur;

public class Chrono implements Runnable {
	//VARIABLES
	private final int PAUSE = 200; //temps dattente entre 2 tours de boucle : 200millisec
	public static int compteTours = 0;
	public static int bouleActive = 0;
	//METHODES
	
	@Override
	public void run() {
		while(Controleur.pacman.isVivant() == false || Controleur.verifBouleBlanche() == false ) {
			if (PommeOrange.getActive() || PommeViolet.getActive()) {
				bouleActive++;
			}else {
				bouleActive = 0;
			}
			compteTours++;
			App.scene.repaint(); //appel de la methode paintComponent de l'objet scene
			try{Thread.sleep(PAUSE);}
			catch(InterruptedException e) {}
		}
	}
}
