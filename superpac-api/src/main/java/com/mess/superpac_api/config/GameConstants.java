package com.mess.superpac_api.config;

public final class GameConstants {

    private GameConstants() {
    }

    // map1
    public static int[][] tab = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 4, 1},
            {1, 2, 1, 2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 2, 1},
            {1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 2, 1, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2, 1},
            {1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1},
            {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1},
            {3, 2, 2, 1, 2, 2, 2, 0, 2, 2, 2, 1, 2, 2, 3},
            {1, 1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1},
            {1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1},
            {1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 1},
            {1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1},
            {1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1},
            {1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 4, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    // map2
    public static int[][] tab2 = {
            {1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 4, 1},
            {1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1},
            {1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1},
            {1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1},
            {1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1},
            {3, 2, 2, 1, 2, 2, 2, 0, 2, 2, 2, 1, 2, 2, 3},
            {1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1},
            {1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1},
            {1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1},
            {1, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1},
            {1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 4, 1},
            {1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
    };

    // Position de pacman tab
    public static int X_POS_PAC = 7;
    public static int Y_POS_PAC = 7;

    // Vie pac
    public static int VIE_PAC = 3;

    // Unite de deplacement tab
    public static final int DEPLACEMENT_X_TAB = 1;
    public static final int DEPLACEMENT_Y_TAB = 1;

    // Unite de deplacement porte
    public static final int DEPLACEMENT_PORTE = 13;

    // sens deplacement
    public static int sens = 0;

    // Position de fantome1 tab
    public static final int X_POS_FANT1 = 1;
    public static final int Y_POS_FANT1 = 1;

    // Position de fantome2 tab
    public static final int X_POS_FANT2 = 13;
    public static final int Y_POS_FANT2 = 13;

    // Position de fantome3 tab
    public static final int X_POS_FANT3 = 1;
    public static final int Y_POS_FANT3 = 13;

    // Position de fantome4 tab
    public static final int X_POS_FANT4 = 13;
    public static final int Y_POS_FANT4 = 1;

    // Position retour fantomes tab
    public static final int X_POS_FANTR = 7;
    public static final int Y_POS_FANTR = 7;

    // Couleur fantome normal
    public static final String COULEUR_FANTOME_NORMAL = "RED";

    // Couleur fantome vulnerable
    public static final String COULEUR_FANTOME_VULNERABLE = "CYAN";

    // Couleurs pacman selon etat
    public static final String COULEUR_PAC_NORMAL = "ORANGE";
    public static final String COULEUR_PAC_INVISIBLE = "MAGENTA";
    public static final String COULEUR_PAC_SUPER = "YELLOW";

    // Couleurs pommes speciales
    public static final String COULEUR_POMME_VIOLETTE = "PINK";
    public static final String COULEUR_POMME_ORANGE = "ORANGE";
    public static final String COULEUR_POMME_VERTE = "GREEN";

    // Score pomme bleu
    public static final int POINT_POMME_BLEU = 100;

    // Score pomme violet
    public static final int POINT_POMME_VIOLET = 300;

    // Score pomme orange
    public static final int POINT_POMME_ORANGE = 500;

    // Score pomme vert
    public static final int POINT_POMME_VERT = 1000;

    // Position de POMME1 tab
    public static final int X_POS_POMME1 = 1;
    public static final int Y_POS_POMME1 = 1;

    // Position de POMME2 tab
    public static final int X_POS_POMME2 = 13;
    public static final int Y_POS_POMME2 = 13;

    // Position de POMME3 tab
    public static final int X_POS_POMME3 = 1;
    public static final int Y_POS_POMME3 = 13;

    // Score fin de jeu
    public static int SCORE_POUR_VIE_PLUS = 5000;

    // Intervalle du game loop (ms)
    public static final int INTERVALLE_TICK_MS = 200;
}
