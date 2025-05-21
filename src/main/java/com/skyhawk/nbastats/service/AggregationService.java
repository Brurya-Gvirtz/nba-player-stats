package com.skyhawk.nbastats.service;

import org.springframework.stereotype.Service;

import com.skyhawk.nbastats.dto.PlayerAggregateResponse;
import com.skyhawk.nbastats.dto.TeamAggregateResponse;
import com.skyhawk.nbastats.respository.PlayerStatsDao;
import com.skyhawk.nbastats.respository.TeamDao;

@Service
public class AggregationService {

    private final PlayerStatsDao playerStatsDao;
    private final TeamDao teamDao;

    public AggregationService(PlayerStatsDao playerStatsDao, TeamDao teamDao) {
        this.playerStatsDao = playerStatsDao;
        this.teamDao = teamDao;
    }

    public PlayerAggregateResponse getPlayerAggregates(Long playerId) {
        return playerStatsDao.getAggregatedStats(playerId);
    }

    public TeamAggregateResponse getTeamAggregates(Long teamId) {
        return teamDao.getTotalPointsForTeam(teamId);
    }
}
