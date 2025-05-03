package entites;

import java.awt.Color;


import ressources.Constantes;


public class Fantome extends Entite{
	//VARIABLES	
	private int direction = random_int(1, 5);
	private static int[][]tab = Constantes.tab;
	private int CopiexPosF;
	private int CopieyPosF;
	private int CopiexPixF;
	private int CopieyPixF;
	private EtatFantome etatFant;
	private int vitesse = 1;
	
	//CONSTRUCTEUR
	public Fantome(int xPosF, int yPosF) {
		this.CopiexPosF = xPosF;
		this.CopieyPosF = yPosF;
		super.xPos = xPosF;
		super.yPos = yPosF;
		super.largeur = Constantes.COTE_FANTOME;
		super.hauteur = Constantes.COTE_FANTOME;
		super.xPix = (xPos ) * Constantes.COTE_CAREE;
		super.yPix = (yPos ) * Constantes.COTE_CAREE;
		this.CopiexPixF = xPix;
		this.CopieyPixF = yPix;
		super.dx = Constantes.DEPLACEMENT_X_PIX;
		super.dy = Constantes.DEPLACEMENT_Y_PIX;
		super.couleur = Color.red;
	}
	//METHODES
	public void setEtat(EtatFantome newEtat) {
		this.etatFant = newEtat;
	}
	public  void action(){
		etatFant.action(this);
	}
	public static int random_int(int Min, int Max){
		     return (int) (Math.random()*(Max-Min))+Min;
	}

	public void DirectionFant() {
		if((verifMurXdroite()||verifMurXdroite()||verifMurXdroite()||verifMurXdroite())) {
		this.direction = random_int(1, 5);
		}
	}
		public int deplacementxFant() {
			//renvoie la nouvelle pos du vaisseau apres deplacement
			if(direction == 1 ) {
				if(verifMurXdroite()) {
					if (PommeOrange.getActive() == false) {
					this.yPos = this.yPos + Constantes.DEPLACEMENT_Y_TAB;
					this.yPix = this.yPix + this.dy;
					}if(PommeOrange.getActive() && vitesse % 2 == 0) {
						this.yPos = this.yPos + Constantes.DEPLACEMENT_Y_TAB;
						this.yPix = this.yPix + this.dy;
					}
				}else {this.direction = random_int(1, 5);}
			}
			if(direction == 2) {
				if(verifMurXgauche()) {
					if (PommeOrange.getActive() == false) {
					this.yPos = this.yPos - Constantes.DEPLACEMENT_Y_TAB;
					this.yPix = this.yPix - this.dy;
					}
					if(PommeOrange.getActive() && vitesse % 2 == 0) {
						this.yPos = this.yPos - Constantes.DEPLACEMENT_Y_TAB;
						this.yPix = this.yPix - this.dy;
					}
				}
				else {this.direction = random_int(1, 5);}
			}
			return this.yPix;
		}
		
		
		public int deplacementyFant() {
			//renvoie la nouvelle pos du vaisseau apres deplacement
			if(direction == 3 ) {
				if(verifMurYhaut()) {
					if (PommeOrange.getActive() == false) {
						//deplacement normal si boulle orange inactif
					this.xPos = this.xPos - Constantes.DEPLACEMENT_X_TAB;
					this.xPix = this.xPix - this.dx;
					}
					if(PommeOrange.getActive() && vitesse % 2 == 0) {
						//deplacement 2X plus lentement si boulle orange actif
						this.xPos = this.xPos - Constantes.DEPLACEMENT_X_TAB;
						this.xPix = this.xPix - this.dx;
					}
				}
				else {this.direction = random_int(1, 5);}
			}if(direction == 4) {
				if(verifMurYbas() ) {
					if (PommeOrange.getActive() == false) {
					this.xPos = this.xPos + Constantes.DEPLACEMENT_X_TAB;
					this.xPix = this.xPix + this.dx;
					}
					if(PommeOrange.getActive() && vitesse % 2 == 0) {
						this.xPos = this.xPos + Constantes.DEPLACEMENT_X_TAB;
						this.xPix = this.xPix + this.dx;
					}
				} 
				else {this.direction = random_int(1, 5);}
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
		public static void setTab(int[][] tab) {
			Fantome.tab = tab;
		}
		public void renisalisationPos() {
			super.xPos = CopiexPosF;
			super.yPos = CopieyPosF;
			super.xPix = CopiexPixF;
			super.yPix = CopieyPixF;
		}
		public void fantMort() {
			super.xPos = Constantes.X_POS_FANTR;
			super.yPos = Constantes.Y_POS_FANTR;
			super.xPix = Constantes.X_POS_FANTR * Constantes.COTE_CAREE;
			super.yPix = Constantes.Y_POS_FANTR * Constantes.COTE_CAREE;
		}
		public int getVitesse() {
			return vitesse;
		}

		public void setVitesse(int vitesse) {
			this.vitesse = vitesse;
		}
		
			
}
