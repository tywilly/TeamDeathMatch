package com.tywilly.CastleSiege.player;

import java.util.ArrayList;

public class PlayerManager {
	
	private ArrayList<TeamPlayer> playerList = new ArrayList<TeamPlayer>();
	
	public void addPlayer(TeamPlayer player){
		playerList.add(player);
		player.getTeam().addPlayer(player);
	}
	
	public void removePlayer(TeamPlayer player){
		playerList.remove(player);
		player.getTeam().removePlayer(player);
	}
	
	public TeamPlayer getPlayer(String playerName){
		
		for(TeamPlayer player : playerList){
			
			if(player.getPlayer().getName() == playerName){
				return player;
			}
			
		}
		
		return null;
		
	}
	
}
