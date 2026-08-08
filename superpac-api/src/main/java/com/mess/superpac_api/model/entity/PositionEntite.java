package com.mess.superpac_api.model.entity;


public class PositionEntite {

    private final int xPos;
    private final int yPos;
    private final String couleur;

    public PositionEntite(int xPos, int yPos, String couleur) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.couleur = couleur;
    }

    public int getxPos() { return xPos; }
    public int getyPos() { return yPos; }
    public String getCouleur() { return couleur; }
}