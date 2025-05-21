package com.skyhawk.nbastats.dto;

public class TeamAggregateResponse {
	
	private String teamName;
    private Long totalPoints;
    private Long totalRebounds;
    private Long totalAssists;
    private Long totalSteals;
    private Long totalBlocks;
    private Long totalFouls;
    private Long totalTurnovers;
    private Long teamId;

    
    public TeamAggregateResponse() {
    }

    public TeamAggregateResponse(Long teamId, Long totalPoints) {
        this.teamId = teamId;
        this.totalPoints = totalPoints;
    }
    
    
    // Getters and setters
    
     public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Long getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Long totalPoints) {
		this.totalPoints = totalPoints;
	}
	public Long getTotalRebounds() {
		return totalRebounds;
	}
	public void setTotalRebounds(Long totalRebounds) {
		this.totalRebounds = totalRebounds;
	}
	public Long getTotalAssists() {
		return totalAssists;
	}
	public void setTotalAssists(Long totalAssists) {
		this.totalAssists = totalAssists;
	}
	public Long getTotalSteals() {
		return totalSteals;
	}
	public void setTotalSteals(Long totalSteals) {
		this.totalSteals = totalSteals;
	}
	public Long getTotalBlocks() {
		return totalBlocks;
	}
	public void setTotalBlocks(Long totalBlocks) {
		this.totalBlocks = totalBlocks;
	}
	public Long getTotalFouls() {
		return totalFouls;
	}
	public void setTotalFouls(Long totalFouls) {
		this.totalFouls = totalFouls;
	}
	public Long getTotalTurnovers() {
		return totalTurnovers;
	}
	public void setTotalTurnovers(Long totalTurnovers) {
		this.totalTurnovers = totalTurnovers;
	}
	
}