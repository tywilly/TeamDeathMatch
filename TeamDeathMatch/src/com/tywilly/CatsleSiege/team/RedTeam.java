package com.tywilly.CatsleSiege.team;

import org.bukkit.ChatColor;

public class RedTeam extends Team{
	
	private static RedTeam instance;
	
	public RedTeam(){
		setTeamColor(ChatColor.RED);
	}

	public static RedTeam getInstance(){
		
		if(instance == null){
			instance = new RedTeam();
		}
		
		return instance;
		
	}
	
}
