package com.tywilly.CastleSiege.team;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import com.tywilly.CastleSiege.player.TeamPlayer;

public class Team {

	private ArrayList<TeamPlayer> playerList = new ArrayList<TeamPlayer>();
	private ChatColor teamColor;
	private int numberOfCaptures = 0;
	private Location spawnLoc;
	
	public void setTeamColor(ChatColor color){
		teamColor = color;
	}
	
	public ArrayList<TeamPlayer> getPlayersList(){
		return playerList;
	}
	
	//Add a player to the list;
	public void addPlayer(TeamPlayer player){
		player.getPlayer().setDisplayName(teamColor + "[" + teamColor.name() + "] " + player.getPlayer().getName() + ChatColor.WHITE);
		player.getPlayer().setPlayerListName(teamColor + player.getPlayer().getName());
		player.getPlayer().setCustomName(teamColor + "[" + teamColor.name() + "] " + player.getPlayer().getName() + ChatColor.WHITE);
		player.getPlayer().sendMessage("You have joined the " + teamColor + teamColor.name() +  " team!");
		playerList.add(player);
	}
	
	//Remove a player from the team list.
	public void removePlayer(TeamPlayer player){
		if(playerList.contains(player)){
			playerList.remove(player);
		}
	}
	
	public int getNumPlayers(){
		return playerList.size();
	}
	
	public void addCapture(){
		numberOfCaptures++;
	}
	
	public int getNumCaptures(){
		return numberOfCaptures;
	}
	
	public void setSpawnLoc(Location loc){
		spawnLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
		
		for(TeamPlayer teamPlayer: playerList){
			teamPlayer.getPlayer().sendMessage("Your teams spawnpoint has moved!");
		}
		
	}
	
	public Location getSpawnLoc(){
		return spawnLoc;
	}
	
	
}
