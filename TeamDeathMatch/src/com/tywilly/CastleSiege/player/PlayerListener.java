package com.tywilly.CastleSiege.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.tywilly.CastleSiege.objective.Objective;
import com.tywilly.CastleSiege.objective.ObjectiveManager;
import com.tywilly.CastleSiege.objective.flag.Flag;
import com.tywilly.CatsleSiege.team.BlueTeam;
import com.tywilly.CatsleSiege.team.NeutralTeam;
import com.tywilly.CatsleSiege.team.RedTeam;

public class PlayerListener implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		//The statement to balance teams.
		if(BlueTeam.getInstance().getNumPlayers() > RedTeam.getInstance().getNumPlayers()){
			
			new PlayerManager().addPlayer(new TeamPlayer(event.getPlayer(), RedTeam.getInstance()));
			
		}else if(BlueTeam.getInstance().getNumPlayers() <= RedTeam.getInstance().getNumPlayers()){
			
			new PlayerManager().addPlayer(new TeamPlayer(event.getPlayer(), BlueTeam.getInstance()));
			
		}
		
		Flag flag = new Flag();
		
		flag.setLocation(event.getPlayer().getLocation());
		flag.setTeamBlock(NeutralTeam.getInstance());
		
		new ObjectiveManager().addFlag(flag);
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
		
		player.teleport(new PlayerManager().getPlayer(player.getName()).getTeam().getSpawnLoc());
		
	}
	
	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event){
		
		for(final Objective flag : new ObjectiveManager().getObjectivesList()){
			if(flag.inRadiusOf(event.getPlayer(), 5) && !flag.isBeingCaptured() && !flag.isTeams(new PlayerManager().getPlayer(event.getPlayer().getName()).getTeam())){
				
				flag.capture(event.getPlayer());
				
			}else{
				//TODO: Add capture multiplier!
			}
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		new PlayerManager().removePlayer(new PlayerManager().getPlayer(event.getPlayer().getName()));
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		
		event.setCancelled(true);
		
	}
	
	
	
}