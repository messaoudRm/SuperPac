package entites;

import java.awt.Color;

public abstract class Entite {
	//VARIABLES
	protected int largeur, hauteur, xPos, yPos, dx, dy;
	protected int xPix;
	protected int yPix;
	protected boolean vivant;
	protected Color couleur;
	protected Boolean invisible;

	//METHODES
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public boolean isVivant() {
		return vivant;
	}
	public void setVivant(boolean vivant) {
		this.vivant = vivant;
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
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
}
