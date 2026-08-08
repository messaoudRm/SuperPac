package com.mess.superpac_api.model.entity;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.state.EtatPac;

public class Pacman extends Entite {
    // VARIABLES
    private static int[][] tab = GameConstants.tab;
    private EtatPac etatPac;

    // CONSTRUCTEUR
    public Pacman() {
        super.xPos = GameConstants.X_POS_PAC;
        super.yPos = GameConstants.Y_POS_PAC;
        super.dx = GameConstants.DEPLACEMENT_X_TAB;
        super.dy = GameConstants.DEPLACEMENT_Y_TAB;
        super.vivant = true;
        super.invisible = false;
    }

    // METHODES
    public void setEtat(EtatPac newEtat) {
        this.etatPac = newEtat;
    }
    public void action() {
        etatPac.action(this);
    }
    public int deplacementxPac() {
        // renvoie la nouvelle pos du pacman apres deplacement
        if (this.dy > 0 && GameConstants.sens == 1) {
            if (verifMurXdroite()) {
                this.yPos = this.yPos + GameConstants.DEPLACEMENT_Y_TAB;
            }
            if (verifPorte()) {
                this.yPos = this.yPos - (GameConstants.DEPLACEMENT_Y_TAB * GameConstants.DEPLACEMENT_PORTE);
            }
        }if (this.dy < 0 && GameConstants.sens == 2) {
            if (verifMurXgauche()) {
                this.yPos = this.yPos - GameConstants.DEPLACEMENT_Y_TAB;
            }
            if (verifPorte()) {
                this.yPos = this.yPos + (GameConstants.DEPLACEMENT_Y_TAB * GameConstants.DEPLACEMENT_PORTE);
            }
        }
        return this.yPos;
    }

    public int deplacementyPac() {
        // renvoie la nouvelle pos du pacman apres deplacement
        if (this.dx < 0 && GameConstants.sens == 3) {
            if (verifMurYhaut()) {
                this.xPos = this.xPos - GameConstants.DEPLACEMENT_X_TAB;
            }
            if (verifPorte()) {
                this.xPos = this.xPos + (GameConstants.DEPLACEMENT_X_TAB * GameConstants.DEPLACEMENT_PORTE);
            }
        }if (this.dx > 0 && GameConstants.sens == 4) {
            if (verifMurYbas()) {
                this.xPos = this.xPos + GameConstants.DEPLACEMENT_X_TAB;
            }
            if (verifPorte()) {
                this.xPos = this.xPos - (GameConstants.DEPLACEMENT_X_TAB * GameConstants.DEPLACEMENT_PORTE);
            }
        }
        return this.xPos;
    }

    public boolean verifMurXdroite() {
        boolean var = true;
        if (tab[this.xPos][this.yPos + GameConstants.DEPLACEMENT_Y_TAB] == 1) {
            var = false;
        }
        return var;
    }

    public boolean verifMurXgauche() {
        boolean var = true;
        if (tab[this.xPos][this.yPos - GameConstants.DEPLACEMENT_Y_TAB] == 1) {
            var = false;
        }
        return var;
    }

    public boolean verifMurYhaut() {
        boolean var = true;
        if (tab[this.xPos - GameConstants.DEPLACEMENT_X_TAB][this.yPos] == 1) {
            var = false;
        }
        return var;
    }

    public boolean verifMurYbas() {
        boolean var = true;
        if (tab[this.xPos + GameConstants.DEPLACEMENT_X_TAB][this.yPos] == 1) {
            var = false;
        }
        return var;
    }

    public boolean verifPorte() {
        boolean var = false;
        if (tab[this.xPos][this.yPos] == 3) {
            var = true;
        }
        return var;
    }

    // change la map pour pacman
    public static void setTab(int[][] tab) {
        Pacman.tab = tab;
    }

    // renisalise pos pour pacman
    public void renisalisationPos() {
        super.xPos = 7;
        super.yPos = 7;
        super.dx = GameConstants.DEPLACEMENT_X_TAB;
        super.dy = GameConstants.DEPLACEMENT_Y_TAB;
    }

    public Boolean getInvisible() {
        return invisible;
    }

    public void setInvisible(boolean vinsible) {
        this.invisible = vinsible;
    }
}
