package com.tywilly.teamdeathmatch.objective;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.tywilly.teamdeathmatch.player.PlayerManager;
import com.tywilly.teamdeathmatch.team.BlueTeam;
import com.tywilly.teamdeathmatch.team.NeutralTeam;
import com.tywilly.teamdeathmatch.team.RedTeam;
import com.tywilly.teamdeathmatch.team.Team;

public class Objective {

	private Location objLoc;
	private Block block;
	private Team team;
	private boolean captured;
	
	public void setTeamBlock(Team teamID){
		
		team = teamID;
		
		if(teamID == NeutralTeam.getInstance()){
			block.setType(Material.IRON_BLOCK);
		}else if(teamID == BlueTeam.getInstance()){
			block.setType(Material.LAPIS_BLOCK);
			BlueTeam.getInstance().addCapture();
		}else if(teamID == RedTeam.getInstance()){
			block.setType(Material.REDSTONE_BLOCK);
			RedTeam.getInstance().addCapture();
			RedTeam.getInstance().setSpawnLoc(objLoc);
		}
		
	}
	
	public void capture(final Player player){
		player.sendMessage("Capturing...");
		
		captured = true;
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				
				setTeamBlock(PlayerManager.getInstance().getPlayer(player.getName()).getTeam());
				player.sendMessage("Captured!");
				captured = false;
				
			}
			
		}, 20000);
	}
	
	public boolean isTeams(Team team){
		if(this.team == team){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isBeingCaptured(){
		return captured;
	}
	
	public Team getTeam(){
		return team;
	}
	
	public void setLocation(Location loc){
		objLoc = loc;
		block = loc.getBlock();
	}
	
	public Location getLocation(){
		return objLoc;
	}
	
	public boolean inRadiusOf(Player player, int radius){
		
		if(player.getLocation().distance(objLoc) <= radius){
			return true;
		}
		return false;
	}
	
}
