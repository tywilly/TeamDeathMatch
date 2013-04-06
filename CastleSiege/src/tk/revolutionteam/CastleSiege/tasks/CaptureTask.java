package tk.revolutionteam.CastleSiege.tasks;

import tk.revolutionteam.CastleSiege.CapturePoint;
import tk.revolutionteam.CastleSiege.CastleSiege;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

/**
 *
 * @author gyroninja
 */
public class CaptureTask implements Runnable {

	CastleSiege cs;

	CapturePoint cp;

	Location loc;

	int timeleft = 400;

	public CaptureTask(CastleSiege cs, CapturePoint cp) {

		this.cs = cs;

		this.cp = cp;

		loc = cp.center;
	}

	@Override
	public void run() {

		if (!cp.capped) {

			if (cs.util.blueNearLocation(loc)) {

				timeleft--;

				if (timeleft == 0) {

					Bukkit.broadcastMessage(ChatColor.GREEN + "Blue captured " + cp.name);

					cp.busy = false;

					cp.capped = true;

					cs.scoreboard.removeItem(cp.name + " cap time");

					
					for (int x = -2; x <= 2; x++) {

						for (int z = -2; z <= 2; z++) {

							cp.center.clone().add(x, 0, z).getBlock().setData((byte) 11);
						}
					}

					return;
				}
			}

			else {

				timeleft += 2;

				if (timeleft >= 400) {

					Bukkit.broadcastMessage(ChatColor.RED + "Blue failed to capture " + cp.name);

					cp.busy = false;

					cs.scoreboard.removeItem(cp.name + " cap time");

					return;
				}
			}

			cs.scoreboard.setItem(cp.name + " cap time", timeleft / 20);

			Bukkit.getScheduler().scheduleSyncDelayedTask(cs, this, 1);
		}
	}
}
