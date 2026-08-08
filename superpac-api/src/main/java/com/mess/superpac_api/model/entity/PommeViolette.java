package com.mess.superpac_api.model.entity;

public class PommeViolette extends Entite {
    // VARIABLES
    private static boolean active = false;
    private static int copteUtilisation = 0;

    // CONSTRUCTEUR
    public PommeViolette(int x, int y) {
        super.xPos = x;
        super.yPos = y;
    }

    // METHODES
    public static boolean getActive() {
        return active;
    }
    public static void setActive(boolean activ) {
        active = activ;
    }
    public static int getCopteUtilisation() {
        return copteUtilisation;
    }
    public static void setCopteUtilisation(int a) {
        copteUtilisation = a;
    }

}
