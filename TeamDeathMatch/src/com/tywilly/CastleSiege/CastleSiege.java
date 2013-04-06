package com.tywilly.CastleSiege;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tywilly.CastleSiege.player.PlayerListener;

public class CastleSiege extends JavaPlugin{
	
	PluginManager pm;
	
	public void onEnable(){
		
		pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerListener(), this);
		
	}
	
	public void onDisable(){
		
	}
	
}
