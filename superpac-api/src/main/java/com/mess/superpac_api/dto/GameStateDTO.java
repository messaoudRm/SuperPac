package com.mess.superpac_api.dto;

import java.util.List;

public record GameStateDTO(
        MapDTO carte,
        EntityDTO pacman,
        String direction,
        List<EntityDTO> fantomes,
        List<EntityDTO> pommes,
        int score,
        int vies,
        String statut,
        int tempsEcoule
) {
}