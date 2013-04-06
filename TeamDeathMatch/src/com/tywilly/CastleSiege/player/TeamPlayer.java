package com.tywilly.CastleSiege.player;

import org.bukkit.entity.Player;

import com.tywilly.CastleSiege.team.Team;

public class TeamPlayer{

	private Player player;
	private Team team;
	
	public TeamPlayer(Player player, Team team){
		this.team = team;
		this.player = player;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Team getTeam(){
		return team;
	}
	
	public Player getPlayer(){
		return player;
	}
	
}
