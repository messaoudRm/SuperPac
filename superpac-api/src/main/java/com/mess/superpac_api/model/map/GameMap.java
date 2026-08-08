package com.mess.superpac_api.model.map;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.enums.TileType;

public class GameMap {

    private int[][] tuiles;

    public GameMap(int[][] carteInitiale) {
        this.tuiles = copier(carteInitiale);
    }

    private int[][] copier(int[][] source) {
        int[][] copie = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            copie[i] = source[i].clone();
        }
        return copie;
    }

    public int getHauteur() { return tuiles.length; }
    public int getLargeur() { return tuiles[0].length; }

    public boolean estDansLesLimites(int x, int y) {
        return x >= 0 && x < getHauteur() && y >= 0 && y < getLargeur();
    }

    public boolean estMur(int x, int y) {
        if (!estDansLesLimites(x, y)) {
            return true;
        }
        return tuiles[x][y] == TileType.MUR.getCode();
    }

    public boolean estPorte(int x, int y) {
        return estDansLesLimites(x, y) && tuiles[x][y] == TileType.PORTE.getCode();
    }

    public TileType getTile(int x, int y) {
        return TileType.fromCode(tuiles[x][y]);
    }

    public int consommer(int x, int y) {
        if (!estDansLesLimites(x, y)) {
            return 0;
        }
        if (tuiles[x][y] == TileType.POINT.getCode()) {
            tuiles[x][y] = TileType.VIDE.getCode();
            return GameConstants.POINT_POMME_BLEU;
        }
        if (tuiles[x][y] == TileType.BONUS.getCode()) {
            tuiles[x][y] = TileType.VIDE.getCode();
            return 0;
        }
        return 0;
    }

    public boolean estVideDePoints() {
        for (int[] ligne : tuiles) {
            for (int valeur : ligne) {
                if (valeur == TileType.POINT.getCode()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void remplacerPar(int[][] nouvelleCarte) {
        this.tuiles = copier(nouvelleCarte);
    }
}
