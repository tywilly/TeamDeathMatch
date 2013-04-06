package tk.revolutionteam.CastleSiege;

import tk.revolutionteam.CastleSiege.tasks.CaptureTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.kitteh.tag.PlayerReceiveNameTagEvent;
import tk.revolutionteam.CastleSiege.tasks.KitActivateTask;
import tk.revolutionteam.CastleSiege.tasks.TabTask;

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

		if (cs.teams.blue.size() <= cs.teams.red.size()) {

			cs.teams.playerTeams.put(event.getPlayer().getName(), "blue");
			cs.teams.blue.add(event.getPlayer().getName());
		}

		else {

			cs.teams.playerTeams.put(event.getPlayer().getName(), "red");
			cs.teams.red.add(event.getPlayer().getName());
		}

		Bukkit.getScheduler().scheduleSyncDelayedTask(cs, new TabTask(cs), 1);

		cs.scoreboard.showToPlayer(event.getPlayer());
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {

		event.getEntity().getInventory().clear();
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {

		Bukkit.getScheduler().scheduleSyncDelayedTask(cs, new KitActivateTask(cs, event.getPlayer().getName()), 1);
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {

		Player p = event.getPlayer();

		if (cs.teams.blue.contains(p.getName())) {

			Block b = p.getLocation().subtract(0, 1, 0).getBlock();

			if (b.getType() == Material.WOOL && b.getData() == 0) {

				if (b.getMetadata("cp").size() > 0) {

					CapturePoint cp = cs.cps.capturePoints.get(b.getMetadata("cp").get(0).asString());

					if (!cp.busy && !cp.capped) {

						Bukkit.getScheduler().scheduleSyncDelayedTask(cs, new CaptureTask(cs, cp), 1);

						cp.busy = true;

						cs.scoreboard.setItem(cp.name + " cap time", 20);
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {

		cs.teams.playerTeams.remove(event.getPlayer().getName());

		cs.teams.blue.remove(event.getPlayer().getName());
		cs.teams.red.remove(event.getPlayer().getName());

		Bukkit.getScheduler().scheduleSyncDelayedTask(cs, new TabTask(cs), 1);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {

		if (!event.getPlayer().isOp()) {

			event.setCancelled(true);
		}

		cs.maps.setMap("world");
	}

	@EventHandler
	public void onNameTag(PlayerReceiveNameTagEvent event) {

		if (cs.teams.blue.contains(event.getNamedPlayer().getName())) {

			if (event.getNamedPlayer().getName().length() > 14) {

				event.setTag((ChatColor.BLUE + event.getNamedPlayer().getName()).substring(0, 16));
			}

			else {

				event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());
			}
		}

		else {

			if (event.getNamedPlayer().getName().length() > 14) {

				event.setTag((ChatColor.RED + event.getNamedPlayer().getName()).substring(0, 16));
			}

			else {

				event.setTag(ChatColor.RED + event.getNamedPlayer().getName());
			}
		}
	}
}
