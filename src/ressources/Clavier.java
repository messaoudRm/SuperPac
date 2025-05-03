package ressources;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import jeu.Controleur;

public class Clavier implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'd') {
			Controleur.pacman.setDy(Constantes.DEPLACEMENT_Y_PIX);
			Constantes.sens =1;
		}
		if(e.getKeyChar() == 'q') {
			Controleur.pacman.setDy(- Constantes.DEPLACEMENT_Y_PIX);
			Constantes.sens =2;
		}
		if(e.getKeyChar() == 'z') {
			Controleur.pacman.setDx(- Constantes.DEPLACEMENT_X_PIX);
			Constantes.sens =3;
		}
		if(e.getKeyChar() == 's') {
			Controleur.pacman.setDx(Constantes.DEPLACEMENT_X_PIX);
			Constantes.sens =4;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
