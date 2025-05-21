package com.skyhawk.nbastats.respository;
import java.sql.*;

import com.skyhawk.nbastats.dto.TeamAggregateResponse;

public class TeamDao {

    public TeamAggregateResponse getTotalPointsForTeam(Long teamId) {
    	String sql = "SELECT SUM(points) as total_points FROM player_game_stats WHERE team_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, teamId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                long totalPoints = rs.getLong("total_points");
                return new TeamAggregateResponse(teamId, totalPoints);
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        // Return a default response if no data found
        return new TeamAggregateResponse(teamId, 0L);
    }

   
}
