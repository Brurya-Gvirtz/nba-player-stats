package com.skyhawk.nbastats.service;

import org.springframework.stereotype.Service;

import com.skyhawk.nbastats.dto.PlayerAggregateResponse;
import com.skyhawk.nbastats.dto.PlayerStatRequest;
import com.skyhawk.nbastats.model.PlayerGameStats;
import com.skyhawk.nbastats.respository.PlayerStatsDao;

import java.util.List;

@Service
public class PlayerStatsService {

    private final PlayerStatsDao playerStatsDao;

    public PlayerStatsService(PlayerStatsDao playerStatsDao) {
        this.playerStatsDao = playerStatsDao;
    }

    public void addPlayerStats(PlayerStatRequest request) {
        PlayerGameStats stats = new PlayerGameStats();
        stats.setPlayerId(request.getPlayerId());
        stats.setGameId(request.getGameId());
        stats.setTeamId(request.getTeamId());
        stats.setPoints(request.getPoints());
        stats.setAssists(request.getAssists());
        stats.setRebounds(request.getRebounds());
        stats.setSteals(request.getSteals());
        stats.setBlocks(request.getBlocks());
        stats.setFouls(request.getFouls());
        stats.setTurnovers(request.getTurnovers());
        stats.setMinutesPlayed(request.getMinutesPlayed());

        playerStatsDao.save(stats);
    }

    public List<PlayerGameStats> getStatsForPlayer(Long playerId) {
        return playerStatsDao.findByPlayerId(playerId);
    }

    public PlayerAggregateResponse getAggregateStats(Long playerId) {
        return playerStatsDao.getAggregatedStats(playerId);
    }
}
