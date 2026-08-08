package com.mess.superpac_api.model.entity;

public abstract class Entite {
    // VARIABLES
    protected int xPos, yPos, dx, dy;
    protected boolean vivant;
    protected String couleur;
    protected Boolean invisible;

    // METHODES
    public int getxPos() {
        return xPos;
    }
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    public int getyPos() {
        return yPos;
    }
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
    public int getDx() {
        return dx;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public int getDy() {
        return dy;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
    public boolean isVivant() {
        return vivant;
    }
    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public Boolean getInvisible() {
        return invisible;
    }
    public void setInvisible(Boolean invisible) {
        this.invisible = invisible;
    }
}
