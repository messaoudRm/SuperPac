package jeu;

import java.awt.Graphics;

import entites.Fantome;
import entites.FantomeNormal;
import entites.FantomeVulnerable;
import entites.InvisiblePac;
import entites.PacNormal;
import entites.Pacman;
import entites.PommeOrange;
import entites.PommeVert;
import entites.PommeViolet;
import entites.SuperPac;
import ressources.Chrono;
import ressources.Constantes;

public class Controleur {
	public static Pacman pacman = new Pacman();
	public static Fantome f1 = new Fantome(Constantes.X_POS_FANT1, Constantes.Y_POS_FANT1);
	public static Fantome f2 = new Fantome(Constantes.X_POS_FANT2, Constantes.Y_POS_FANT2);
	public static Fantome f3 = new Fantome(Constantes.X_POS_FANT3, Constantes.Y_POS_FANT3);
	public static Fantome f4 = new Fantome(Constantes.X_POS_FANT4, Constantes.Y_POS_FANT4);
	public static PommeViolet pommeViolet = new PommeViolet(Constantes.X_POS_POMME1, Constantes.Y_POS_POMME1);
	public static PommeOrange pommeOrange = new PommeOrange(Constantes.X_POS_POMME2, Constantes.Y_POS_POMME2);
	public static PommeVert pommeVert= new PommeVert(Constantes.X_POS_POMME3, Constantes.Y_POS_POMME3);
	public static int score = 0;
	public static int bouleActive =0;
	public static int[][]tab = Constantes.tab;
	public static int varOrange =0;
	public static int varViolet =0;
	

	public Controleur() {
		super();
	}
	public static void controle(Graphics g2) {
		//demande au vue de ce dessiner
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (tab[i][j] == 2 || tab[i][j] == 3 ||tab[i][j] == 0|| tab[i][j] == 4) {
					//AFFIVHAGE CAREE BLACK
					App.scene.afficheCareeBlack(g2);
					if (tab[i][j] == 2 ) {
						//AFFIVHAGE POMME BLANCHE
						App.scene.affichePommeBlanche(g2);
						
					}if (i == pommeViolet.getxPos() 
							&& j == pommeViolet.getyPos()
							&& tab[i][j] == 4 ) {
						//AFFIVHAGE POMME SPECIALE PACMAN INVISIBLE 
						App.scene.affichePommeSpPink(g2);
					}if (i == pommeOrange.getxPos() 
							&& j == pommeOrange.getyPos()
							&& tab[i][j] == 4 ) {
						//AFFIVHAGE POMME SPECIALE SUPER PACMAN 
						App.scene.affichePommeSpOrange(g2);
					}if (i == pommeVert.getxPos() 
							&& j == pommeVert.getyPos()
							&& tab[i][j] == 4 && PommeVert.getVarVert() == 1 ) {
						//AFFIVHAGE POMME SPECIALE CHANGMENT MAP
						App.scene.affichePommeSpVert(g2);
						//POMME VERT MANGE CHANGE MAP
						pommeVert.swipMap();
						
					}if(i == pommeVert.getxPos() 
							&& j == pommeVert.getyPos()
							&& tab[i][j] == 4 && PommeVert.getVarVert() == 2) {
						//AFFIVHAGE POMME BLANCHE A LA PLACE DE LA POMME VERT DANS LA DEUSIEME MAP
						App.scene.affichePommeBlanche(g2);
					}
					
					
					if(i == pacman.getxPos() 
						&& j ==pacman.getyPos()
						&& tab[i][j] == 2 )  {
						tab[i][j] = 0;
						//POMME BLANCHE MANGE SUPPRIME POMME DE LA MAP ET AUGMANTE LE SCORE
						App.scene.afficheCareeBlack(g2);
						score = score + Constantes.POINT_POMME_BLEU;
						
					}
					if(i == pacman.getxPos() 
							&& j ==pacman.getyPos()
							&& tab[i][j] == 4 )  {
							tab[i][j] = 0;
							//POMME SPECIALE MANGE SUPPRIME POMME 
							App.scene.afficheCareeBlack(g2);
							
						}
					
			}
				if (tab[i][j] == 1) {
					//AFFICHGE MUR
					App.scene.afficheCareeBleu(g2);
					
				}
				//DEPLACEMENT AXE X DES PIXELS
				App.scene.setxPix( App.scene.getxPix() + Constantes.COTE_CAREE);
			
		}
			//DEPLACEMENT AXE Y DES PIXELS
			App.scene.setxPix(0);
			App.scene.setyPix( App.scene.getyPix() + Constantes.COTE_CAREE);
	}
		
		
		
		
		
		if (Chrono.compteTours < 10) {
			//AFFICHE GOOD LUCK AVANT LE DEBUT DE LA PARTIE
			App.scene.afficheGoodLuck(g2);
			App.scene.setxPix(0);
			App.scene.setyPix(0);
		}
		
	
		
		else if (pacman.isVivant()) {
			App.scene.setxPix(0);
			App.scene.setyPix(0);
		//Affiche score et vie pac
		App.scene.afficheScoreEtVie(g2);
		
		//Dessin pacman
		App.scene.affichePacman(g2);
		//DESSIN FANTOME
		App.scene.afficheFantome(g2);
		
		verifFant();
		verifBoule();

		//VIE PAC AUGMANTE DE 1 APRES SCORE 5000
		if(score % Constantes.SCORE_POUR_VIE_PLUS == 0 && score != 0) {
			Constantes.SCORE_POUR_VIE_PLUS = Constantes.SCORE_POUR_VIE_PLUS + Constantes.SCORE_POUR_VIE_PLUS ;
					Constantes.VIE_PAC ++;
		}
		
		}
		//FIN DE JEU PACMAN MORT
		if(pacman.isVivant() == false) {
			App.scene.afficheGameOver(g2);
			App.scene.setxPix(0);
			App.scene.setyPix(0);
			}
		//FIN DE JEU PACMAN GAGNE
		if(pacman.isVivant() == true &&  verifBouleBlanche()) {
			App.scene.afficheYouWin(g2);
			App.scene.setxPix(0);
			App.scene.setyPix(0);
			}
	}
	public static void verifBoule() {
		//VERIFIE SI LA BOULE SPECIALE VIOLET EST MANGE
		if(pacman.getxPos() == pommeViolet.getxPos() 
			&& pacman.getyPos() ==pommeViolet.getyPos()
			&& bouleActive != 1 && PommeViolet.getCopteUtilisation() == 0){
			bouleActive = 1;
			}
		//VERIFIE SI LA BOULE SPECIALE ORANGE EST MANGE
		if(pacman.getxPos() == pommeOrange.getxPos() 
				&& pacman.getyPos() == pommeOrange.getyPos()
				&& bouleActive != 2 && PommeOrange.getCopteUtilisation() == 0){
				bouleActive = 2;
		}
			

		switch (bouleActive) {
		case 1:
			//ACTIVE LA BOULE VIOLET ET CHANGE L'ETAT DU PACMAN EN INVISIBLE
			PommeViolet.setActive(true);
			PommeViolet.setCopteUtilisation(1);
			pacman.setEtat(new InvisiblePac());
			pacman.action();
			varViolet++;
			if (varViolet == 1) {
				score = score + Constantes.POINT_POMME_VIOLET;
				varViolet++;
			}
			break;
		case 2:
			//ACTIVE LA BOULE ORANGE ET CHANGE L'ETAT DU PACMAN EN SUPER PACMAN ET LES PHONTOME EN VULNERABLE
			PommeOrange.setActive(true);
			PommeOrange.setCopteUtilisation(1);
			pacman.setEtat(new SuperPac());
			pacman.action();
			f1.setEtat(new FantomeVulnerable());
			f1.action();
			f2.setEtat(new FantomeVulnerable());
			f2.action();
			f3.setEtat(new FantomeVulnerable());
			f3.action();
			f4.setEtat(new FantomeVulnerable());
			f4.action();
			varOrange++;
			if (varOrange == 1) {
				score = score + Constantes.POINT_POMME_ORANGE;
				varOrange++;
			}
			
			break;
		case 3:
			//FAIT REVENIR LE PACMAN ET LES FANTOME A LEUR ETAT INITIALE
			Constantes.Y_POS_PAC = pacman.getyPos();
			Constantes.X_POS_PAC = pacman.getxPos();
			pacman.setEtat(new PacNormal());
			pacman.action();
			f1.setEtat(new FantomeNormal());
			f1.action();
			f2.setEtat(new FantomeNormal());
			f2.action();
			f3.setEtat(new FantomeNormal());
			f3.action();
			f4.setEtat(new FantomeNormal());
			f4.action();
			break;
		}
	}
	public static void verifFant() {
		//VERIFIE LA COLLISION AVEC LES FANTOME SI IL YA COLLISION LA VIE DU PACMAN DECREMENTE
		if(((pacman.getxPos() == f1.getxPos() && pacman.getyPos() == f1.getyPos())
			||(pacman.getxPos() == f2.getxPos() && pacman.getyPos() == f2.getyPos())
			||(pacman.getxPos() == f3.getxPos() && pacman.getyPos() ==f3.getyPos())
			||(pacman.getxPos() == f4.getxPos() && pacman.getyPos() == f4.getyPos()))
				&& pacman.getInvisible() == false) {
			Constantes.VIE_PAC --;
			if(Constantes.VIE_PAC <= 0) {
				// SI VIE = 0 PACMAN MORT
				pacman.setVivant(false);
			}
		}

	}
	public static Boolean verifBouleBlanche() {
		//VERIFIE SI IL YA 0 BOULE BLANCHE POUR TERMINER LA PARTIE 
		boolean verif = true;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[i][j] == 2) {
					verif = false;
				}
			}
		}
		return verif;
	}
	public static int getVarViolet() {
		return varViolet;
	}
	public static void setVarViolet(int v) {
		varViolet = v;
	}
	public static int getVarOrange() {
		return varOrange;
	}
	public static void setVarOrange(int v) {
		varOrange = v;
	}

}
