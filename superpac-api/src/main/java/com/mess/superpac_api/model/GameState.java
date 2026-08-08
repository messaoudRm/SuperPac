package com.mess.superpac_api.model;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.model.entity.Fantome;
import com.mess.superpac_api.model.entity.Pacman;
import com.mess.superpac_api.model.entity.PositionEntite;
import com.mess.superpac_api.model.enums.Direction;
import com.mess.superpac_api.model.enums.GameStatus;
import com.mess.superpac_api.model.enums.PouvoirType;
import com.mess.superpac_api.model.map.GameMap;
import java.util.List;

public class GameState {

    private GameMap gameMap;
    private final Pacman pacman;
    private final List<Fantome> fantomes;
    private final PositionEntite pommeViolette;
    private final PositionEntite pommeOrange;
    private final PositionEntite pommeVerte;

    private boolean pommeVioletteUtilisee = false;
    private boolean pommeOrangeUtilisee = false;
    private int niveauPommeVerteFranchi = 0;

    private PouvoirType pouvoirActif = PouvoirType.AUCUN;
    private int pouvoirTicksRestants = 0;

    private Direction direction = Direction.AUCUNE;

    private int score = 0;
    private int vies = GameConstants.VIE_PAC;
    private int seuilProchaineVieBonus = GameConstants.SCORE_POUR_VIE_PLUS;
    private int compteTours = 0;
    private GameStatus statut = GameStatus.EN_ATTENTE;

    public GameState() {
        this.gameMap = new GameMap(GameConstants.tab);

        this.pacman = new Pacman();

        this.fantomes = List.of(
                new Fantome(GameConstants.X_POS_FANT1, GameConstants.Y_POS_FANT1),
                new Fantome(GameConstants.X_POS_FANT2, GameConstants.Y_POS_FANT2),
                new Fantome(GameConstants.X_POS_FANT3, GameConstants.Y_POS_FANT3),
                new Fantome(GameConstants.X_POS_FANT4, GameConstants.Y_POS_FANT4)
        );

        this.pommeViolette = new PositionEntite(
                GameConstants.X_POS_POMME1,
                GameConstants.Y_POS_POMME1,
                GameConstants.COULEUR_POMME_VIOLETTE
        );

        this.pommeOrange = new PositionEntite(
                GameConstants.X_POS_POMME2,
                GameConstants.Y_POS_POMME2,
                GameConstants.COULEUR_POMME_ORANGE
        );

        this.pommeVerte = new PositionEntite(
                GameConstants.X_POS_POMME3,
                GameConstants.Y_POS_POMME3,
                GameConstants.COULEUR_POMME_VERTE
        );
    }

    public GameMap getCarte() { return gameMap; }
    public Pacman getPacman() { return pacman; }
    public List<Fantome> getFantomes() { return fantomes; }
    public PositionEntite getPommeViolette() { return pommeViolette; }
    public PositionEntite getPommeOrange() { return pommeOrange; }
    public PositionEntite getPommeVerte() { return pommeVerte; }

    public boolean isPommeVioletteUtilisee() { return pommeVioletteUtilisee; }
    public void setPommeVioletteUtilisee(boolean pommeVioletteUtilisee) {
        this.pommeVioletteUtilisee = pommeVioletteUtilisee;
    }

    public boolean isPommeOrangeUtilisee() { return pommeOrangeUtilisee; }
    public void setPommeOrangeUtilisee(boolean pommeOrangeUtilisee) {
        this.pommeOrangeUtilisee = pommeOrangeUtilisee;
    }

    public int getNiveauPommeVerteFranchi() { return niveauPommeVerteFranchi; }
    public void setNiveauPommeVerteFranchi(int niveauPommeVerteFranchi) {
        this.niveauPommeVerteFranchi = niveauPommeVerteFranchi;
    }

    public PouvoirType getPouvoirActif() { return pouvoirActif; }
    public void setPouvoirActif(PouvoirType pouvoirActif) { this.pouvoirActif = pouvoirActif; }

    public int getPouvoirTicksRestants() { return pouvoirTicksRestants; }
    public void setPouvoirTicksRestants(int pouvoirTicksRestants) {
        this.pouvoirTicksRestants = pouvoirTicksRestants;
    }

    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getVies() { return vies; }
    public void setVies(int vies) { this.vies = vies; }

    public int getSeuilProchaineVieBonus() { return seuilProchaineVieBonus; }
    public void setSeuilProchaineVieBonus(int seuilProchaineVieBonus) {
        this.seuilProchaineVieBonus = seuilProchaineVieBonus;
    }

    public int getCompteTours() { return compteTours; }
    public void setCompteTours(int compteTours) { this.compteTours = compteTours; }

    public GameStatus getStatut() { return statut; }
    public void setStatut(GameStatus statut) { this.statut = statut; }

    public void setCarte(GameMap gameMap) { this.gameMap = gameMap; }
}
