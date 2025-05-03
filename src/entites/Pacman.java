package entites;



import ressources.Constantes;

public class Pacman extends Entite {
	//VARIABLES		
	private static int[][] tab =Constantes.tab;
	private EtatPac etatPac;
	//CONSTRUCTEUR
	public Pacman() {
		super.xPos = Constantes.X_POS_PAC;
		super.yPos = Constantes.Y_POS_PAC;
		super.largeur = Constantes.COTE_PAC;
		super.hauteur = Constantes.COTE_PAC;
		super.xPix = (xPos ) * Constantes.COTE_CAREE;
		super.yPix = (yPos ) * Constantes.COTE_CAREE;
		super.dx = Constantes.DEPLACEMENT_X_PIX;
		super.dy = Constantes.DEPLACEMENT_Y_PIX;
		super.vivant = true;
		super.invisible = false;

	}
	//METHODES
	public void setEtat(EtatPac newEtat) {
		this.etatPac = newEtat;
	}
	public void action(){
		etatPac.action(this);
	}
	public int deplacementxPac() {
		//renvoie la nouvelle pos du pacman apres deplacement 
		if(this.dy > 0 && Constantes.sens == 1) {
			if(verifMurXdroite()) {
				this.yPos = this.yPos + Constantes.DEPLACEMENT_Y_TAB;
				this.yPix = this.yPix + this.dy;
			}
			if(verifPorte()) {
				this.yPos = this.yPos - (Constantes.DEPLACEMENT_Y_TAB * Constantes.DEPLACEMENT_PORTE);
				this.yPix = this.yPix - (this.dy * Constantes.DEPLACEMENT_PORTE);
			}
		}if(this.dy < 0 && Constantes.sens == 2) {
			if(verifMurXgauche()) {
				this.yPos = this.yPos - Constantes.DEPLACEMENT_Y_TAB;
				this.yPix = this.yPix + this.dy;
			}
			if(verifPorte()) {
				this.yPos = this.yPos + (Constantes.DEPLACEMENT_Y_TAB * Constantes.DEPLACEMENT_PORTE);
				this.yPix = this.yPix - (this.dy * Constantes.DEPLACEMENT_PORTE);
			}
		}
		return this.yPix;
	}
	
	
	public int deplacementyPac() {
		//renvoie la nouvelle pos du pacman apres deplacement
		if(this.dx < 0 && Constantes.sens == 3 ) {
			if(verifMurYhaut()) {
				this.xPos = this.xPos - Constantes.DEPLACEMENT_X_TAB;
				this.xPix = this.xPix + this.dx;
			}
			if(verifPorte()) {
				this.xPos = this.xPos + (Constantes.DEPLACEMENT_X_TAB * Constantes.DEPLACEMENT_PORTE);
				this.xPix = this.xPix - (this.dx * Constantes.DEPLACEMENT_PORTE);
			}
		}if(this.dx > 0 && Constantes.sens == 4) {
			if(verifMurYbas()) {
				this.xPos = this.xPos + Constantes.DEPLACEMENT_X_TAB;
				this.xPix = this.xPix + this.dx;
			}
			if(verifPorte()) {
				this.xPos = this.xPos - (Constantes.DEPLACEMENT_X_TAB * Constantes.DEPLACEMENT_PORTE);
				this.xPix = this.xPix - (this.dx * Constantes.DEPLACEMENT_PORTE);
			}
		}
		return this.xPix;
	}
	public boolean verifMurXdroite() {
		boolean var = true;
		if(tab[this.xPos][this.yPos + Constantes.DEPLACEMENT_Y_TAB] == 1 ) {
			var = false;
		}
		return var;
	}
	public boolean verifMurXgauche() {
		boolean var = true;
		if(tab[this.xPos][this.yPos - Constantes.DEPLACEMENT_Y_TAB] == 1 ) {
			var = false;
		}
		return var;
	}
	public boolean verifMurYhaut() {
		boolean var = true;
		if(tab[this.xPos - Constantes.DEPLACEMENT_X_TAB][this.yPos] == 1) {
			var = false;
		}
		return var;
	}
	public boolean verifMurYbas() {
		boolean var = true;
		if(tab[this.xPos + Constantes.DEPLACEMENT_X_TAB][this.yPos] == 1) {
			var = false;
		}
		return var;
	}
	public boolean verifPorte() {
		boolean var = false;
		if(tab[this.xPos][this.yPos] == 3) {
			var = true;
		}
		return var;
	}
	//change la map pour pacman
	public static void setTab(int[][] tab) {
		Pacman.tab = tab;
	}
	//renisalise pos pour pacman
	public void renisalisationPos() {
		super.xPos = 7;
		super.yPos = 7;
		super.largeur = Constantes.COTE_PAC;
		super.hauteur = Constantes.COTE_PAC;
		super.xPix = (xPos ) * Constantes.COTE_CAREE;
		super.yPix = (yPos ) * Constantes.COTE_CAREE;
		super.dx = Constantes.DEPLACEMENT_X_PIX;
		super.dy = Constantes.DEPLACEMENT_Y_PIX;
	}
	public Boolean getInvisible() {
		return invisible;
	}
	public void setInvisible(boolean vinsible) {
		this.invisible = vinsible;
	}
}