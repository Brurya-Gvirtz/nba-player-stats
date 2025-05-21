package com.skyhawk.nbastats.dto;

public class PlayerAggregateResponse {
	private Long playerId;
    private String playerName;
    private Long totalPoints;
    private Long totalRebounds;
    private Long totalAssists;
    private Long totalSteals;
    private Long totalBlocks;
    private Long totalFouls;
    private Long totalTurnovers;
    private Double averageMinutes;

    
    public PlayerAggregateResponse(Long totalPoints, Long totalRebounds, Long totalAssists,
    		Long totalSteals, Long totalBlocks, Long totalFouls,
            Long totalTurnovers, double totalMinutesPlayed) {
    	 this.totalPoints = totalPoints;
         this.totalRebounds = totalRebounds;
         this.totalAssists = totalAssists;
         this.totalSteals = totalSteals;
         this.totalBlocks = totalBlocks;
         this.totalFouls = totalFouls;
         this.totalTurnovers = totalTurnovers;
         this.averageMinutes = totalMinutesPlayed;
    }
    
    
    // Getters and setters
    public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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
	public Double getAverageMinutes() {
		return averageMinutes;
	}
	public void setAverageMinutes(Double averageMinutes) {
		this.averageMinutes = averageMinutes;
	}
	
}
