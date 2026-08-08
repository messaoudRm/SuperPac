package com.mess.superpac_api.model.entity;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.service.GameService;

public class PommeVerte extends Entite {
    // VARIABLES
    private static int[][] tab = clonerCarte(GameConstants.tab);
    private static int var = 1;
    private final GameService gameService;

    // CONSTRUCTEUR
    public PommeVerte(int x, int y, GameService gameService) {
        super.xPos = x;
        super.yPos = y;
        this.gameService = gameService;
    }

    // METHODES
    public void swipMap() {
        // change la map
        if (gameService.getPacman().getxPos() == this.xPos
                && gameService.getPacman().getyPos() == this.yPos) {
            gameService.setScore(gameService.getScore() + GameConstants.POINT_POMME_VERT);
            verifTab();
            if (var <= 2) {
                gameService.setVarViolet(0);
                gameService.setVarOrange(0);
                gameService.setTab(PommeVerte.tab);
                Pacman.setTab(PommeVerte.tab);
                Fantome.setTab(PommeVerte.tab);
                // rechargeMap(PommeVerte.tab);
                gameService.getPacman().renisalisationPos();
                gameService.getF1().renisalisationPos();
                gameService.getF2().renisalisationPos();
                gameService.getF3().renisalisationPos();
                gameService.getF4().renisalisationPos();
                PommeOrange.setCopteUtilisation(0);
                PommeViolette.setCopteUtilisation(0);
            }
        }
    }

    public void rechargeMap(int[][] tab) {
        // remets des pomme dans la map
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] == 0) {
                    tab[i][j] = 2;
                }
            }
        }
    }

    public void verifTab() {
        if (var == 1) {
            PommeVerte.tab = clonerCarte(GameConstants.tab2);
            var++;
        } else if (var == 2) {
            var++;
            tab[GameConstants.X_POS_POMME3][GameConstants.Y_POS_POMME3] = 0;
        }
    }

    public static int getVarVert() {
        return var;
    }

    public static void setVarVert(int v) {
        var = v;
    }

    public static void setTab(int[][] nouvelleCarte) {
        PommeVerte.tab = clonerCarte(nouvelleCarte);
    }

    private static int[][] clonerCarte(int[][] source) {
        int[][] copie = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            copie[i] = source[i].clone();
        }
        return copie;
    }

}