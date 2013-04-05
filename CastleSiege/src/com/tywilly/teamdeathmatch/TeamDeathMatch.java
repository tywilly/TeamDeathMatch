package com.tywilly.teamdeathmatch;

import org.bukkit.plugin.java.JavaPlugin;

import com.tywilly.teamdeathmatch.player.PlayerListener;
import org.bukkit.Bukkit;

public class TeamDeathMatch extends JavaPlugin{

	@Override
	public void onEnable(){
		
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		
	}
}
