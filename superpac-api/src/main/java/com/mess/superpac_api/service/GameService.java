package com.mess.superpac_api.service;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Fantome;
import com.mess.superpac_api.model.entity.Pacman;
import com.mess.superpac_api.model.entity.PommeOrange;
import com.mess.superpac_api.model.entity.PommeVerte;
import com.mess.superpac_api.model.entity.PommeViolette;
import com.mess.superpac_api.model.state.FantomeNormal;
import com.mess.superpac_api.model.state.FantomeVulnerable;
import com.mess.superpac_api.model.state.InvisiblePac;
import com.mess.superpac_api.model.state.PacNormal;
import com.mess.superpac_api.model.state.SuperPac;
import com.mess.superpac_api.model.GameState;
import com.mess.superpac_api.model.enums.Direction;
import com.mess.superpac_api.model.enums.GameStatus;
import com.mess.superpac_api.model.enums.PouvoirType;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameState gameState = new GameState();
    private final ClavierService clavierService;

    private Pacman pacman = new Pacman();
    private Fantome f1 = new Fantome(GameConstants.X_POS_FANT1, GameConstants.Y_POS_FANT1);
    private Fantome f2 = new Fantome(GameConstants.X_POS_FANT2, GameConstants.Y_POS_FANT2);
    private Fantome f3 = new Fantome(GameConstants.X_POS_FANT3, GameConstants.Y_POS_FANT3);
    private Fantome f4 = new Fantome(GameConstants.X_POS_FANT4, GameConstants.Y_POS_FANT4);
    private PommeViolette pommeViolette = new PommeViolette(GameConstants.X_POS_POMME1, GameConstants.Y_POS_POMME1);
    private PommeOrange pommeOrange = new PommeOrange(GameConstants.X_POS_POMME2, GameConstants.Y_POS_POMME2);
    private PommeVerte pommeVerte = new PommeVerte(GameConstants.X_POS_POMME3, GameConstants.Y_POS_POMME3, this);
    private int score = 0;
    private int bouleActive = 0;
    private int[][] tab = clonerCarte(GameConstants.tab);
    private int varOrange = 0;
    private int varViolet = 0;

    private int compteTours = 0;
    private int compteurPouvoirActif = 0;

    public GameService(ClavierService clavierService) {
        this.clavierService = clavierService;
    }

    public synchronized void handleInput(String input) {
        // traduit la touche en direction/sens le deplacement reel se fait au prochain tick
        clavierService.keyTyped(input, pacman);
    }

    public synchronized void restartGame() {
        // reinitialise le score et les compteurs
        score = 0;
        bouleActive = 0;
        varOrange = 0;
        varViolet = 0;
        compteTours = 0;
        compteurPouvoirActif = 0;
        tab = clonerCarte(GameConstants.tab);
        Pacman.setTab(tab);
        Fantome.setTab(tab);
        PommeVerte.setVarVert(1);
        PommeVerte.setTab(tab);

        // reinitialise pacman
        pacman.renisalisationPos();
        pacman.setVivant(true);
        pacman.setInvisible(false);
        pacman.setCouleur(GameConstants.COULEUR_PAC_NORMAL);

        // reinitialise les fantomes
        reinitialiserFantome(f1);
        reinitialiserFantome(f2);
        reinitialiserFantome(f3);
        reinitialiserFantome(f4);

        // reinitialise les pommes speciales
        PommeOrange.setActive(false);
        PommeOrange.setCopteUtilisation(0);
        PommeViolette.setActive(false);
        PommeViolette.setCopteUtilisation(0);

        // reinitialise les valeurs
        GameConstants.VIE_PAC = 3;
        GameConstants.SCORE_POUR_VIE_PLUS = 5000;
        GameConstants.sens = 0;
        GameConstants.X_POS_PAC = 7;
        GameConstants.Y_POS_PAC = 7;
    }

    private void reinitialiserFantome(Fantome fantome) {
        fantome.renisalisationPos();
        fantome.setEtat(new FantomeNormal());
        fantome.action();
    }

    private static int[][] clonerCarte(int[][] source) {
        int[][] copie = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            copie[i] = source[i].clone();
        }
        return copie;
    }

    private void deplacerFantome(Fantome fantome) {
        fantome.deplacementxFant();
        fantome.deplacementyFant();
    }

    public synchronized void mettreAJourEtat() {
        // si pacman est mort la partie est terminee
        if (!pacman.isVivant()) {
            return;
        }

        // deplacement pacman
        pacman.deplacementxPac();
        pacman.deplacementyPac();

        // deplacement des 4 fantomes
        deplacerFantome(f1);
        deplacerFantome(f2);
        deplacerFantome(f3);
        deplacerFantome(f4);

        // gestion du compteur de duree du pouvoir actif
        if (PommeOrange.getActive() || PommeViolette.getActive()) {
            compteurPouvoirActif++;
        } else {
            compteurPouvoirActif = 0;
        }
        compteTours++;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (tab[i][j] == 2 || tab[i][j] == 3 || tab[i][j] == 0 || tab[i][j] == 4) {

                    if (i == pommeVerte.getxPos()
                            && j == pommeVerte.getyPos()
                            && tab[i][j] == 4 && PommeVerte.getVarVert() == 1) {
                        // POMME VERT MANGE CHANGE MAP
                        pommeVerte.swipMap();
                    }

                    if (i == pacman.getxPos()
                            && j == pacman.getyPos()
                            && tab[i][j] == 2) {
                        tab[i][j] = 0;
                        // POMME BLANCHE MANGE SUPPRIME POMME DE LA MAP ET AUGMANTE LE SCORE
                        score = score + GameConstants.POINT_POMME_BLEU;
                    }
                    if (i == pacman.getxPos()
                            && j == pacman.getyPos()
                            && tab[i][j] == 4) {
                        tab[i][j] = 0;
                        // POMME SPECIALE MANGE SUPPRIME POMME
                    }
                }
            }
        }

        if (compteTours >= 10 && pacman.isVivant()) {
            verifFant();
            verifBoule();

            // VIE PAC AUGMANTE DE 1 APRES SCORE 5000
            if (score % GameConstants.SCORE_POUR_VIE_PLUS == 0 && score != 0) {
                GameConstants.SCORE_POUR_VIE_PLUS = GameConstants.SCORE_POUR_VIE_PLUS + GameConstants.SCORE_POUR_VIE_PLUS;
                GameConstants.VIE_PAC++;
            }
        }
    }

    public synchronized GameState getState() {
        synchroniserGameState();
        return gameState;
    }

    private void synchroniserGameState() {
        // Carte : synchronise les tuiles mangees
        gameState.getCarte().remplacerPar(tab);

        // Pacman
        gameState.getPacman().setxPos(pacman.getxPos());
        gameState.getPacman().setyPos(pacman.getyPos());
        gameState.getPacman().setCouleur(pacman.getCouleur());
        gameState.getPacman().setInvisible(pacman.getInvisible());
        gameState.getPacman().setVivant(pacman.isVivant());

        // Fantomes
        synchroniserFantome(gameState.getFantomes().get(0), f1);
        synchroniserFantome(gameState.getFantomes().get(1), f2);
        synchroniserFantome(gameState.getFantomes().get(2), f3);
        synchroniserFantome(gameState.getFantomes().get(3), f4);

        // Pommes : positions fixes
        gameState.setPommeVioletteUtilisee(PommeViolette.getCopteUtilisation() == 1);
        gameState.setPommeOrangeUtilisee(PommeOrange.getCopteUtilisation() == 1);
        gameState.setNiveauPommeVerteFranchi(PommeVerte.getVarVert());

        gameState.setScore(score);
        gameState.setVies(GameConstants.VIE_PAC);
        gameState.setCompteTours(compteTours);

        // Direction
        switch (GameConstants.sens) {
            case 1:
                gameState.setDirection(Direction.DROITE);
                break;
            case 2:
                gameState.setDirection(Direction.GAUCHE);
                break;
            case 3:
                gameState.setDirection(Direction.HAUT);
                break;
            case 4:
                gameState.setDirection(Direction.BAS);
                break;
            default:
                gameState.setDirection(Direction.AUCUNE);
                break;
        }

        // Pouvoir actif
        if (bouleActive == 1) {
            gameState.setPouvoirActif(PouvoirType.INVISIBILITE);
        } else if (bouleActive == 2) {
            gameState.setPouvoirActif(PouvoirType.SUPER);
        } else {
            gameState.setPouvoirActif(PouvoirType.AUCUN);
        }
        gameState.setPouvoirTicksRestants(Math.max(0, 20 - compteurPouvoirActif));

        // Statut
        if (!pacman.isVivant()) {
            gameState.setStatut(GameStatus.GAME_OVER);
        } else if (verifBouleBlanche()) {
            gameState.setStatut(GameStatus.VICTOIRE);
        } else if (compteTours < 10) {
            gameState.setStatut(GameStatus.EN_ATTENTE);
        } else {
            gameState.setStatut(GameStatus.EN_COURS);
        }
    }

    private void synchroniserFantome(Fantome cible, Fantome source) {
        cible.setxPos(source.getxPos());
        cible.setyPos(source.getyPos());
        cible.setCouleur(source.getCouleur());
        cible.setVitesse(source.getVitesse());
    }

    public void verifBoule() {
        // VERIFIE SI LA BOULE SPECIALE VIOLET EST MANGE
        if (pacman.getxPos() == pommeViolette.getxPos()
                && pacman.getyPos() == pommeViolette.getyPos()
                && bouleActive != 1 && PommeViolette.getCopteUtilisation() == 0) {
            bouleActive = 1;
        }
        // VERIFIE SI LA BOULE SPECIALE ORANGE EST MANGE
        if (pacman.getxPos() == pommeOrange.getxPos()
                && pacman.getyPos() == pommeOrange.getyPos()
                && bouleActive != 2 && PommeOrange.getCopteUtilisation() == 0) {
            bouleActive = 2;
        }

        switch (bouleActive) {
            case 1:
                // ACTIVE LA BOULE VIOLET ET CHANGE L'ETAT DU PACMAN EN INVISIBLE
                PommeViolette.setActive(true);
                PommeViolette.setCopteUtilisation(1);
                pacman.setEtat(new InvisiblePac(this));
                pacman.action();
                varViolet++;
                if (varViolet == 1) {
                    score = score + GameConstants.POINT_POMME_VIOLET;
                    varViolet++;
                }
                break;
            case 2:
                // ACTIVE LA BOULE ORANGE ET CHANGE L'ETAT DU PACMAN EN SUPER PACMAN ET LES PHONTOME EN VULNERABLE
                PommeOrange.setActive(true);
                PommeOrange.setCopteUtilisation(1);
                pacman.setEtat(new SuperPac(this));
                pacman.action();
                f1.setEtat(new FantomeVulnerable());
                f1.action();
                f2.setEtat(new FantomeVulnerable());
                f2.action();
                f3.setEtat(new FantomeVulnerable());
                f3.action();
                f4.setEtat(new FantomeVulnerable());
                f4.action();
                varOrange++;
                if (varOrange == 1) {
                    score = score + GameConstants.POINT_POMME_ORANGE;
                    varOrange++;
                }
                break;
            case 3:
                // FAIT REVENIR LE PACMAN ET LES FANTOME A LEUR ETAT INITIALE
                GameConstants.Y_POS_PAC = pacman.getyPos();
                GameConstants.X_POS_PAC = pacman.getxPos();
                pacman.setEtat(new PacNormal());
                pacman.action();
                f1.setEtat(new FantomeNormal());
                f1.action();
                f2.setEtat(new FantomeNormal());
                f2.action();
                f3.setEtat(new FantomeNormal());
                f3.action();
                f4.setEtat(new FantomeNormal());
                f4.action();
                break;
        }
    }

    public void verifFant() {
        // VERIFIE LA COLLISION AVEC LES FANTOME SI IL YA COLLISION LA VIE DU PACMAN DECREMENTE
        if (((pacman.getxPos() == f1.getxPos() && pacman.getyPos() == f1.getyPos())
                || (pacman.getxPos() == f2.getxPos() && pacman.getyPos() == f2.getyPos())
                || (pacman.getxPos() == f3.getxPos() && pacman.getyPos() == f3.getyPos())
                || (pacman.getxPos() == f4.getxPos() && pacman.getyPos() == f4.getyPos()))
                && pacman.getInvisible() == false) {
            GameConstants.VIE_PAC--;
            if (GameConstants.VIE_PAC <= 0) {
                // SI VIE = 0 PACMAN MORT
                pacman.setVivant(false);
            }
        }
    }

    public Boolean verifBouleBlanche() {
        // VERIFIE SI IL YA 0 BOULE BLANCHE POUR TERMINER LA PARTIE
        boolean verif = true;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] == 2) {
                    verif = false;
                }
            }
        }
        return verif;
    }

    public int getVarViolet() {
        return varViolet;
    }
    public void setVarViolet(int v) {
        varViolet = v;
    }
    public int getVarOrange() {
        return varOrange;
    }
    public void setVarOrange(int v) {
        varOrange = v;
    }
    public Pacman getPacman() {
        return pacman;
    }
    public Fantome getF1() {
        return f1;
    }
    public Fantome getF2() {
        return f2;
    }
    public Fantome getF3() {
        return f3;
    }
    public Fantome getF4() {
        return f4;
    }
    public PommeViolette getPommeViolette() {
        return pommeViolette;
    }
    public PommeOrange getPommeOrange() {
        return pommeOrange;
    }
    public PommeVerte getPommeVerte() {
        return pommeVerte;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getBouleActive() {
        return bouleActive;
    }
    public void setBouleActive(int bouleActive) {
        this.bouleActive = bouleActive;
    }
    public int getCompteurPouvoirActif() {
        return compteurPouvoirActif;
    }
    public int[][] getTab() {
        return tab;
    }
    public void setTab(int[][] tab) {
        this.tab = tab;
    }

}