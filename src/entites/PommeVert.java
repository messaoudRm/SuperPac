package entites;

import jeu.Controleur;
import ressources.Constantes;

public class PommeVert extends Entite {
	//VARIABLES
	private static int[][]tab =Constantes.tab;
	private static int var = 1;
	//CONSTRUCTEUR
	public PommeVert(int x, int y) {
		super.xPos = x;
		super.yPos = y;
		super.largeur = Constantes.COTE_POMME_SPECIALE;
		super.hauteur = Constantes.COTE_POMME_SPECIALE;
		super.xPix = xPix + Constantes.CENTRER_POMME_SPECIALE;
		super.yPix = yPix + Constantes.CENTRER_POMME_SPECIALE;
	}
	//METHODES
	public void swipMap() {
		//change la map
		if(Controleur.pacman.xPos == this.xPos 
			&& Controleur.pacman.yPos == this.yPos ) {
			Controleur.score = Controleur.score + Constantes.POINT_POMME_VERT;
			verifTab();
			if (var <= 2) {
			Controleur.setVarViolet(0);
			Controleur.setVarOrange(0);
			Controleur.tab = PommeVert.tab;
			Pacman.setTab(PommeVert.tab);
			Fantome.setTab(PommeVert.tab);
			//rechargeMap(PommeVert.tab);
			Controleur.pacman.renisalisationPos();
			Controleur.f1.renisalisationPos();
			Controleur.f2.renisalisationPos();
			Controleur.f3.renisalisationPos();
			Controleur.f4.renisalisationPos();
			PommeOrange.setCopteUtilisation(0);
			PommeViolet.setCopteUtilisation(0);
			}
		}
	}
	public void rechargeMap(int[][]tab) {
		//remets des pomme dans la map
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[i][j] == 0) {
					tab[i][j] = 2;
				}
			}
		}
	}
	public void verifTab() {
		if(var == 1) {
			PommeVert.tab = Constantes.tab2;
			var++;
		}
		else if(var == 2){
			var++;
			tab[Constantes.X_POS_POMME3][Constantes.Y_POS_POMME3] = 0;
		}
	}
	public static int getVarVert() {
		return var;
	} 
	
}