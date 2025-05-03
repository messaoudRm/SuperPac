package entites;

import ressources.Constantes;

public class PommeOrange extends Entite {
	//VARIABLES	
	private static boolean mortel = true;
	private static boolean active = false;
	private static int copteUtilisation = 0;
	//CONSTRUCTEUR
	public PommeOrange(int x, int y) {
		super.xPos = x;
		super.yPos = y;
		super.largeur = Constantes.COTE_POMME_SPECIALE;
		super.hauteur = Constantes.COTE_POMME_SPECIALE;
		super.xPix = xPix + Constantes.CENTRER_POMME_SPECIALE;
		super.yPix = yPix + Constantes.CENTRER_POMME_SPECIALE;
	}
	public boolean getMortel() {
		return mortel;
	}
	public static void setMortel(boolean mort) {
		mortel = mort;
	}
	public static boolean getActive() {
		return active;
	}
	public static void setActive(boolean activ) {
		active = activ; 
	}
	public static int getCopteUtilisation() {
		return copteUtilisation;
	}
	public static void setCopteUtilisation(int a) {
		copteUtilisation = a;
	}
}
