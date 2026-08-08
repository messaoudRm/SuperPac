package com.mess.superpac_api.model.enums;

public enum Direction {

    AUCUNE,
    DROITE,
    GAUCHE,
    HAUT,
    BAS;


    public static Direction depuisTouche(String touche) {
        if (touche == null) {
            return AUCUNE;
        }
        return switch (touche) {
            case "d" -> DROITE;
            case "q" -> GAUCHE;
            case "z" -> HAUT;
            case "s" -> BAS;
            default -> AUCUNE;
        };
    }
}