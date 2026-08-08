package com.mess.superpac_api.dto;

public record MapDTO(
        String[][] tuiles,
        int largeur,
        int hauteur
) {
}