package com.skyhawk.nbastats.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skyhawk.nbastats.dto.PlayerStatRequest;
import com.skyhawk.nbastats.model.PlayerGameStats;
import com.skyhawk.nbastats.service.PlayerStatsService;

@RestController
@RequestMapping("/api/player-stats")
public class PlayerStatsController {

    private final PlayerStatsService playerStatsService;

    @Autowired
    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @PostMapping
    public void savePlayerStat(@RequestBody PlayerStatRequest request) {
        playerStatsService.addPlayerStats(request);
    }

    @GetMapping("/player/{playerId}")
    public List<PlayerGameStats> getStatsByPlayer(@PathVariable Long playerId) {
        return playerStatsService.getStatsForPlayer(playerId);
    }
}

