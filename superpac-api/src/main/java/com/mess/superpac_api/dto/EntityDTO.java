package com.mess.superpac_api.dto;

public record EntityDTO(
        EntityType type,
        PositionDTO position,
        String couleur,
        String etat,
        boolean actif
) {
}