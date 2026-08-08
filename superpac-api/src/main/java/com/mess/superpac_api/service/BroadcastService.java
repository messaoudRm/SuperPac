package com.mess.superpac_api.service;

import com.mess.superpac_api.config.GameConstants;
import com.mess.superpac_api.dto.GameStateDTO;
import com.mess.superpac_api.mapper.GameStateMapper;
import com.mess.superpac_api.model.GameState;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class BroadcastService {

    private static final String DESTINATION = "/topic/game-state";
    private final SimpMessagingTemplate messagingTemplate;

    public BroadcastService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void diffuser(GameState gameState) {
        GameStateDTO dto = GameStateMapper.versDTO(gameState);
        messagingTemplate.convertAndSend(DESTINATION, dto);
    }
}
