package jeu;

import javax.swing.JFrame;

import ressources.Constantes;

public class App {
	//VARIABLES
	public static Vue scene;
	public static Controleur controleur;

	public static void main(String[] args) {
		//Creation de la fenetre de lapp
		JFrame fenetre = new JFrame("jeu pacman");
		fenetre.setSize(Constantes.LARGEUR_FENETRE, Constantes.HAUTEUR_FENETRE);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setAlwaysOnTop(true);
		//Assosiation du panneau a la fenetre
		scene = new Vue();
		fenetre.setContentPane(scene);
		fenetre.setVisible(true);
		
	}
}
