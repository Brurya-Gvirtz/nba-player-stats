package com.skyhawk.nbastats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skyhawk.nbastats.dto.PlayerAggregateResponse;
import com.skyhawk.nbastats.dto.TeamAggregateResponse;
import com.skyhawk.nbastats.service.AggregationService;

@RestController
@RequestMapping("/api/aggregate")
public class AggregationController {

    private final AggregationService aggregationService;

    @Autowired
    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/player/{playerId}")
    public PlayerAggregateResponse getPlayerAggregate(@PathVariable Long playerId) {
        return aggregationService.getPlayerAggregates(playerId);
    }

    @GetMapping("/team/{teamId}")
    public TeamAggregateResponse getTeamAggregate(@PathVariable Long teamId) {
        return aggregationService.getTeamAggregates(teamId);
    }
}
