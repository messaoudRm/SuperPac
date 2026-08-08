package com.mess.superpac_api.model.state;

import com.mess.superpac_api.model.entity.Pacman;

public interface EtatPac {
    void action(Pacman pac);
}