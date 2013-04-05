package net.gyroninja.CastleSiege;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 *
 * @author gyroninja
 */
public class CSListener implements Listener {

	CastleSiege cs;

	public CSListener(CastleSiege cs) {

		this.cs = cs;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		if (cs.teams.blueTeam.size() > cs.teams.redTeam.size()) {

			cs.teams.playerTeams.put(event.getPlayer().getName(), "red");
			cs.teams.redTeam.add(event.getPlayer().getName());
		}

		else {

			cs.teams.playerTeams.put(event.getPlayer().getName(), "blue");
			cs.teams.blueTeam.add(event.getPlayer().getName());
		}
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {

		event.getEntity().getInventory().clear();
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
//TODO Set spawn location
//		event.setRespawnLocation();
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {

		
	}
}
