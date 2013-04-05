package com.tywilly.teamdeathmatch.team;

import org.bukkit.ChatColor;

public class BlueTeam extends Team{
	
	private static BlueTeam instance;
	
	public BlueTeam(){
		
		setTeamColor(ChatColor.BLUE);
		
	}
	
	
	
	public static BlueTeam getInstance(){
		
		if(instance == null){
			instance = new BlueTeam();
		}
		
		return instance;
		
	}
	
}
