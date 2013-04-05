package com.tywilly.teamdeathmatch.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.tywilly.teamdeathmatch.objective.Objective;
import com.tywilly.teamdeathmatch.objective.ObjectiveManager;
import com.tywilly.teamdeathmatch.objective.flag.Flag;
import com.tywilly.teamdeathmatch.team.BlueTeam;
import com.tywilly.teamdeathmatch.team.NeutralTeam;
import com.tywilly.teamdeathmatch.team.RedTeam;

public class PlayerListener implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		//The statement to balance teams.
		if(BlueTeam.getInstance().getNumPlayers() > RedTeam.getInstance().getNumPlayers()){
			
			PlayerManager.getInstance().addPlayer(new TeamPlayer(event.getPlayer(), RedTeam.getInstance()));
			
		}else if(BlueTeam.getInstance().getNumPlayers() <= RedTeam.getInstance().getNumPlayers()){
			
			PlayerManager.getInstance().addPlayer(new TeamPlayer(event.getPlayer(), BlueTeam.getInstance()));
			
		}
		
		Flag flag = new Flag();
		
		flag.setLocation(event.getPlayer().getLocation());
		flag.setTeamBlock(NeutralTeam.getInstance());
		
		ObjectiveManager.getInstance().addFlag(flag);
	}
	
	@EventHandler
	public void onPlayerDeath(EntityDeathEvent event){
		

		
		if(event.getEntity() instanceof Player){
			
			Player player = (Player) event.getEntity();
			
			player.getInventory().clear();
			
		}
	}
	
	@EventHandler
	public void onPlayerSpawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		
		player.teleport(PlayerManager.getInstance().getPlayer(player.getName()).getTeam().getSpawnLoc());
		
	}
	
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event){
		
		for(final Objective flag : ObjectiveManager.getInstance().getObjectivesList()){
			if(flag.inRadiusOf(event.getPlayer(), 5) && !flag.isBeingCaptured() && !flag.isTeams(PlayerManager.getInstance().getPlayer(event.getPlayer().getName()).getTeam())){
				
				flag.capture(event.getPlayer());
				
			}else{
				//TODO: Add capture multiplier!
			}
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		PlayerManager.getInstance().removePlayer(PlayerManager.getInstance().getPlayer(event.getPlayer().getName()));
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		
		event.setCancelled(true);
		
	}
	
	
	
}