package com.mess.superpac_api.model.enums;

public enum TileType {

    VIDE(0),
    MUR(1),
    POINT(2),
    PORTE(3),
    BONUS(4);

    private final int code;

    TileType(int code) {
        this.code = code;
    }

    public int getCode() { return code; }

    public static TileType fromCode(int code) {
        for (TileType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        return VIDE;
    }
}