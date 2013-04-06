package tk.revolutionteam.CastleSiege.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.mcsg.double0negative.tabapi.TabAPI;
import tk.revolutionteam.CastleSiege.CastleSiege;

/**
 *
 * @author gyroninja
 */
public class TabTask implements Runnable {

	CastleSiege cs;

	public TabTask(CastleSiege cs) {

		this.cs = cs;
	}

	@Override
	public void run() {

		for (Player p : Bukkit.getOnlinePlayers()) {

			TabAPI.setTabString(cs, p, 0, 0, ChatColor.BLUE + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Blue Team");

			for (int i = 0; i < cs.teams.blue.size(); i++) {

				TabAPI.setTabString(cs, p, i + 1, 0, ChatColor.BLUE + cs.teams.blue.get(i));
			}

			TabAPI.setTabString(cs, p, 0, 1, ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Red Team");

			for (int i = 0; i < cs.teams.red.size(); i++) {

				TabAPI.setTabString(cs, p, i + 1, 1, ChatColor.RED + cs.teams.red.get(i));
			}

			TabAPI.setTabString(cs, p, 0, 2, ChatColor.GREEN + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "Admins");

			TabAPI.setTabString(cs, p, 1, 2, ChatColor.GREEN + "gyroninja");
			TabAPI.setTabString(cs, p, 2, 2, ChatColor.GREEN + "ivonator123");

			TabAPI.updatePlayer(p);
		}
	}
}
