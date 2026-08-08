package com.mess.superpac_api.model.entity;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.state.EtatFantome;

public class Fantome extends Entite {
    // VARIABLES
    private int direction = random_int(1, 5);
    private static int[][] tab = GameConstants.tab;
    private int CopiexPosF;
    private int CopieyPosF;
    private EtatFantome etatFant;
    private int vitesse = 1;

    // CONSTRUCTEUR
    public Fantome(int xPosF, int yPosF) {
        this.CopiexPosF = xPosF;
        this.CopieyPosF = yPosF;
        super.xPos = xPosF;
        super.yPos = yPosF;
        super.couleur = GameConstants.COULEUR_FANTOME_NORMAL;
    }

    // METHODES
    public void setEtat(EtatFantome newEtat) {
        this.etatFant = newEtat;
    }
    public EtatFantome getEtat() {
        return etatFant;
    }
    public void action() {
        etatFant.action(this);
    }
    public static int random_int(int Min, int Max) {
        return (int) (Math.random() * (Max - Min)) + Min;
    }

    public void DirectionFant() {
        if ((verifMurXdroite() || verifMurXgauche() || verifMurYhaut() || verifMurYbas())) {
            this.direction = random_int(1, 5);
        }
    }

    public int deplacementxFant() {
        // renvoie la nouvelle pos du vaisseau apres deplacement
        if (direction == 1) {
            if (verifMurXdroite()) {
                if (PommeOrange.getActive() == false) {
                    this.yPos = this.yPos + GameConstants.DEPLACEMENT_Y_TAB;
                }if (PommeOrange.getActive() && vitesse % 2 == 0) {
                    this.yPos = this.yPos + GameConstants.DEPLACEMENT_Y_TAB;
                }
            } else {this.direction = random_int(1, 5);}
        }
        if (direction == 2) {
            if (verifMurXgauche()) {
                if (PommeOrange.getActive() == false) {
                    this.yPos = this.yPos - GameConstants.DEPLACEMENT_Y_TAB;
                }
                if (PommeOrange.getActive() && vitesse % 2 == 0) {
                    this.yPos = this.yPos - GameConstants.DEPLACEMENT_Y_TAB;
                }
            }
            else {this.direction = random_int(1, 5);}
        }
        return this.yPos;
    }

    public int deplacementyFant() {
        // renvoie la nouvelle pos du vaisseau apres deplacement
        if (direction == 3) {
            if (verifMurYhaut()) {
                if (PommeOrange.getActive() == false) {
                    // deplacement normal si boulle orange inactif
                    this.xPos = this.xPos - GameConstants.DEPLACEMENT_X_TAB;
                }
                if (PommeOrange.getActive() && vitesse % 2 == 0) {
                    // deplacement 2X plus lentement si boulle orange actif
                    this.xPos = this.xPos - GameConstants.DEPLACEMENT_X_TAB;
                }
            }
            else {this.direction = random_int(1, 5);}
        }
        if (direction == 4) {
            if (verifMurYbas()) {
                if (PommeOrange.getActive() == false) {
                    this.xPos = this.xPos + GameConstants.DEPLACEMENT_X_TAB;
                }
                if (PommeOrange.getActive() && vitesse % 2 == 0) {
                    this.xPos = this.xPos + GameConstants.DEPLACEMENT_X_TAB;
                }
            }
            else {this.direction = random_int(1, 5);}
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

    public static void setTab(int[][] tab) {
        Fantome.tab = tab;
    }

    public void renisalisationPos() {
        super.xPos = CopiexPosF;
        super.yPos = CopieyPosF;
    }

    public void fantMort() {
        super.xPos = GameConstants.X_POS_FANTR;
        super.yPos = GameConstants.Y_POS_FANTR;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

}
