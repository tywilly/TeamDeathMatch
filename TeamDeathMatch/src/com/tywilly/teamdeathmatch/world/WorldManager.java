package com.tywilly.teamdeathmatch.world;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldManager {

	private static WorldManager instance;
	
	
	public void setWorld(World oldWorld ,World newWorld){
		for(World world : Bukkit.getWorlds()){
			
			if(world == oldWorld){
				
				//TODO: Add the code for loading and unloading worlds!
				Bukkit.unloadWorld(oldWorld, false);
				Bukkit.getWorlds().add(newWorld);
				
			}
		}
	}
	
	
	
	
	public static WorldManager getInstance(){
		
		if(instance == null){
			instance = new WorldManager();
		}
		
		return instance;
		
	}
	
}

