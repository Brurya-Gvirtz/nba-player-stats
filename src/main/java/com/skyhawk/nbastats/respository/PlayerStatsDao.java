package com.skyhawk.nbastats.respository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.skyhawk.nbastats.dto.PlayerAggregateResponse;
import com.skyhawk.nbastats.model.PlayerGameStats;


public class PlayerStatsDao {

    public List<PlayerGameStats> findByPlayerId(Long playerId) {
        List<PlayerGameStats> stats = new ArrayList<>();
        String sql = "SELECT * FROM player_game_stats WHERE player_id = ?";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, playerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                stats.add(mapResultSetToPlayerGameStats(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stats;
    }

    public PlayerAggregateResponse getAggregatedStats(Long playerId) {
        String sql = """
                SELECT 
                    SUM(points) AS totalPoints,
                    SUM(rebounds) AS totalRebounds,
                    SUM(assists) AS totalAssists,
                    SUM(steals) AS totalSteals,
                    SUM(blocks) AS totalBlocks,
                    SUM(fouls) AS totalFouls,
                    SUM(turnovers) AS totalTurnovers,
                    SUM(minutes_played) AS totalMinutes
                FROM player_game_stats
                WHERE player_id = ?
                """;

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, playerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new PlayerAggregateResponse(
                    rs.getLong("totalPoints"),
                    rs.getLong("totalRebounds"),
                    rs.getLong("totalAssists"),
                    rs.getLong("totalSteals"),
                    rs.getLong("totalBlocks"),
                    rs.getLong("totalFouls"),
                    rs.getLong("totalTurnovers"),
                    rs.getDouble("totalMinutes")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void save(PlayerGameStats stats) {
        String sql = """
                INSERT INTO player_game_stats (
                    player_id, game_id, team_id, points, rebounds, assists,
                    steals, blocks, fouls, turnovers, minutes_played, last_updated
                ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, stats.getPlayerId());
            stmt.setLong(2, stats.getGameId());
            stmt.setLong(3, stats.getTeamId());
            stmt.setInt(4, stats.getPoints());
            stmt.setInt(5, stats.getRebounds());
            stmt.setInt(6, stats.getAssists());
            stmt.setInt(7, stats.getSteals());
            stmt.setInt(8, stats.getBlocks());
            stmt.setInt(9, stats.getFouls());
            stmt.setInt(10, stats.getTurnovers());
            stmt.setDouble(11, stats.getMinutesPlayed());
            stmt.setTimestamp(12, Timestamp.valueOf(stats.getLastUpdated()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PlayerGameStats mapResultSetToPlayerGameStats(ResultSet rs) throws SQLException {
        PlayerGameStats stats = new PlayerGameStats();
        stats.setId(rs.getLong("id"));
        stats.setPlayerId(rs.getLong("player_id"));
        stats.setGameId(rs.getLong("game_id"));
        stats.setTeamId(rs.getLong("team_id"));
        stats.setPoints(rs.getInt("points"));
        stats.setRebounds(rs.getInt("rebounds"));
        stats.setAssists(rs.getInt("assists"));
        stats.setSteals(rs.getInt("steals"));
        stats.setBlocks(rs.getInt("blocks"));
        stats.setFouls(rs.getInt("fouls"));
        stats.setTurnovers(rs.getInt("turnovers"));
        stats.setMinutesPlayed(rs.getDouble("minutes_played"));
        stats.setLastUpdated(rs.getTimestamp("last_updated").toLocalDateTime());
        return stats;
    }
}

