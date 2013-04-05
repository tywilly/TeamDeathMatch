package com.tywilly.teamdeathmatch.team;

public class NeutralTeam extends Team{

	private static NeutralTeam instance;
	
	public static NeutralTeam getInstance(){
		
		if(instance == null){
			
			instance = new NeutralTeam();
			
		}
		
		return instance;
		
	}
	
}
