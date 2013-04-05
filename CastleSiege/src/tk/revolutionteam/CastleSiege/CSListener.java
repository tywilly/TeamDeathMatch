package tk.revolutionteam.CastleSiege;

import tk.revolutionteam.CastleSiege.tasks.CaptureTask;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
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

		if (cs.teams.blue.size() > cs.teams.red.size()) {

			cs.teams.playerTeams.put(event.getPlayer().getName(), "red");
			cs.teams.red.add(event.getPlayer().getName());
		}

		else {

			cs.teams.playerTeams.put(event.getPlayer().getName(), "blue");
			cs.teams.blue.add(event.getPlayer().getName());
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

		Player p = event.getPlayer();

		if (cs.teams.blue.contains(p.getName())) {

			Block b = p.getLocation().subtract(0, 1, 0).getBlock();

			if (b.getType() == Material.WOOL && b.getData() == 0) {

				for (CapturePoint cp : cs.cps.capturePoints) {

					if (cp.locations.contains(b.getLocation())) {

						Bukkit.getScheduler().scheduleSyncDelayedTask(cs, new CaptureTask(cs, cp), 1);
					}
				}
			}
		}
	}
}
