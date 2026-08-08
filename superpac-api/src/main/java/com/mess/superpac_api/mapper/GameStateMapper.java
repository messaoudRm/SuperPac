package com.mess.superpac_api.mapper;

import com.mess.superpac_api.dto.EntityDTO;
import com.mess.superpac_api.dto.EntityType;
import com.mess.superpac_api.dto.GameStateDTO;
import com.mess.superpac_api.dto.MapDTO;
import com.mess.superpac_api.dto.PositionDTO;
import com.mess.superpac_api.model.GameState;
import com.mess.superpac_api.model.entity.Entite;
import com.mess.superpac_api.model.entity.Fantome;
import com.mess.superpac_api.model.entity.PositionEntite;
import com.mess.superpac_api.model.map.GameMap;
import com.mess.superpac_api.model.state.FantomeVulnerable;

import java.util.List;

public final class GameStateMapper {

    private GameStateMapper() {
    }

    public static GameStateDTO versDTO(GameState gameState) {
        return new GameStateDTO(
                versMapDTO(gameState.getCarte()),
                versPacmanDTO(gameState),
                gameState.getDirection().name(),
                versFantomesDTO(gameState),
                versPommesDTO(gameState),
                gameState.getScore(),
                gameState.getVies(),
                gameState.getStatut().name(),
                gameState.getCompteTours()
        );
    }

    private static MapDTO versMapDTO(GameMap gameMap) {

        String[][] tuiles = new String[gameMap.getHauteur()][gameMap.getLargeur()];

        for (int i = 0; i < gameMap.getHauteur(); i++) {
            for (int j = 0; j < gameMap.getLargeur(); j++) {
                tuiles[i][j] = gameMap.getTile(i, j).name();
            }
        }
        return new MapDTO(tuiles, gameMap.getLargeur(), gameMap.getHauteur()
        );
    }

    private static EntityDTO versPacmanDTO(GameState gameState) {
        return versEntityDTO(gameState.getPacman(), EntityType.PACMAN, etatPacman(gameState));
    }

    private static List<EntityDTO> versFantomesDTO(GameState gameState) {
        return gameState.getFantomes()
                .stream()
                .map(f -> versEntityDTO(f, EntityType.FANTOME, etatFantome(f)))
                .toList();
    }

    private static List<EntityDTO> versPommesDTO(GameState gameState) {
        return List.of(
                versPommeDTO(gameState.getPommeViolette(), EntityType.POMME_VIOLETTE, !gameState.isPommeVioletteUtilisee()),
                versPommeDTO(gameState.getPommeOrange(), EntityType.POMME_ORANGE, !gameState.isPommeOrangeUtilisee()),
                versPommeDTO(gameState.getPommeVerte(), EntityType.POMME_VERTE, gameState.getNiveauPommeVerteFranchi() < 2)
        );
    }

    private static EntityDTO versEntityDTO(Entite entite, EntityType type, String etat) {
        return new EntityDTO(type, new PositionDTO(entite.getxPos(), entite.getyPos()), entite.getCouleur(), etat, true);
    }

    private static EntityDTO versPommeDTO(
            PositionEntite pomme,
            EntityType type,
            boolean disponible) {

        String etat;

        if (disponible) {
            etat = "DISPONIBLE";
        } else {
            etat = "UTILISEE";
        }

        return new EntityDTO(
                type,
                new PositionDTO(
                        pomme.getxPos(),
                        pomme.getyPos()
                ),
                pomme.getCouleur(),
                etat,
                disponible
        );
    }

    private static String etatPacman(GameState gameState) {

        switch (gameState.getPouvoirActif()) {

            case INVISIBILITE:
                return "INVISIBLE";

            case SUPER:
                return "SUPER";

            case AUCUN:
            default:
                return "NORMAL";
        }
    }

    private static String etatFantome(Fantome fantome) {

        if (fantome.getEtat() instanceof FantomeVulnerable) {
            return "VULNERABLE";
        } else {
            return "NORMAL";
        }
    }
}