package jeu;

import java.awt.Color;



import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import ressources.Chrono;
import ressources.Clavier;
import ressources.Constantes;

public class Vue extends JPanel {
	//VARIABLES
	private int xPix = 0;
	private int yPix = 0;
	private Font afficheScore = new Font("Arial", Font.PLAIN, 20);
	private Font afficheText = new Font("Arial", Font.PLAIN, 80);
	//CONSTRUCTEUR
	public Vue() {
		super();
		//instantiation clavier
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		//instantiation chrono
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	//METHODES
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D) g;
		//Dessin de map
		Controleur.controle(g2);
	}
		
	public int getxPix() {
		return xPix;
	}
	public void setxPix(int xPix) {
		this.xPix = xPix;
	}
	public int getyPix() {
		return yPix;
	}
	public void setyPix(int yPix) {
		this.yPix = yPix;
	}

	public void afficheCareeBlack(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.black);
		g2.fillRect(xPix, yPix, Constantes.COTE_CAREE, Constantes.COTE_CAREE);
		
	}

	public void affichePommeBlanche(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.white);
		g2.fillRect(xPix + Constantes.CENTRER_POMME, yPix + Constantes.CENTRER_POMME, Constantes.COTE_POMME, Constantes.COTE_POMME);
		
		
	}

	public void affichePommeSpPink(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.pink);
		g2.fillRect(xPix + Constantes.CENTRER_POMME_SPECIALE, yPix + Constantes.CENTRER_POMME_SPECIALE, Constantes.COTE_POMME_SPECIALE, Constantes.COTE_POMME_SPECIALE);
		
		
	}

	public void affichePommeSpOrange(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.ORANGE);
		g2.fillRect(xPix + Constantes.CENTRER_POMME_SPECIALE, yPix + Constantes.CENTRER_POMME_SPECIALE, Constantes.COTE_POMME_SPECIALE, Constantes.COTE_POMME_SPECIALE);
		
		
	}

	public void affichePommeSpVert(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.green);
		g2.fillRect(xPix + Constantes.CENTRER_POMME_SPECIALE, yPix + Constantes.CENTRER_POMME_SPECIALE, Constantes.COTE_POMME_SPECIALE, Constantes.COTE_POMME_SPECIALE);
		
		
	}

	public void afficheCareeBleu(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.blue);
		g2.fillRect(xPix, yPix, Constantes.COTE_CAREE, Constantes.COTE_CAREE);
		
	}

	public void afficheGoodLuck(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.green);
		g2.setFont(afficheText);
		g2.drawString("Good luck ", 150, 350);
		
	}

	public void afficheScoreEtVie(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.ORANGE);
		g2.setFont(afficheScore);
		g2.drawString("SCORE : "+ Controleur.score, Constantes.SCORE_X, Constantes.SCORE_Y);
		g2.drawString("VIE PAC : "+ Constantes.VIE_PAC , Constantes.VIE_X, Constantes.VIE_Y);
		
	}

	public void affichePacman(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Controleur.pacman.getCouleur());
		g2.fillRect(Controleur.pacman.deplacementxPac(), Controleur.pacman.deplacementyPac(), Controleur.pacman.getLargeur(), Controleur.pacman.getHauteur());// tab 2d col==lig et lig==col

		
	}

	public void afficheFantome(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Controleur.f1.getCouleur());
		g2.fillRect(Controleur.f1.deplacementxFant(), Controleur.f1.deplacementyFant(), Controleur.f1.getLargeur(), Controleur.f1.getHauteur());
		g2.fillRect(Controleur.f2.deplacementxFant(), Controleur.f2.deplacementyFant(), Controleur.f2.getLargeur(), Controleur.f2.getHauteur());
		g2.fillRect(Controleur.f3.deplacementxFant(), Controleur.f3.deplacementyFant(), Controleur.f3.getLargeur(), Controleur.f3.getHauteur());
		g2.fillRect(Controleur.f4.deplacementxFant(), Controleur.f4.deplacementyFant(), Controleur.f4.getLargeur(), Controleur.f4.getHauteur());
		
	}

	public void afficheGameOver(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.green);
		g2.setFont(afficheText);
		g2.drawString("Game Over ", 115, 300);
		g2.drawString("SCORE : " + Controleur.score, 50, 400);
		
	}
	public void afficheYouWin(Graphics g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.green);
		g2.setFont(afficheText);
		g2.drawString("YOU WIN ", 115, 300);
		g2.drawString("SCORE : " + Controleur.score, 50, 400);
		
	}
	

}
