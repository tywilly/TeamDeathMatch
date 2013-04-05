package com.tywilly.teamdeathmatch;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tywilly.teamdeathmatch.player.PlayerListener;

public class TeamDeathMatch extends JavaPlugin{
	
	PluginManager pm;
	
	public void onEnable(){
		
		pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerListener(), this);
		
	}
	
	public void onDisable(){
		
	}
	
}
