package com.tywilly.CatsleSiege.team;

public class NeutralTeam extends Team{

	private static NeutralTeam instance;
	
	public static NeutralTeam getInstance(){
		
		if(instance == null){
			
			instance = new NeutralTeam();
			
		}
		
		return instance;
		
	}
	
}
