package tk.revolutionteam.CastleSiege.tasks;

import tk.revolutionteam.CastleSiege.CapturePoint;
import tk.revolutionteam.CastleSiege.CastleSiege;
import tk.revolutionteam.CastleSiege.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author gyroninja
 */
public class CaptureTask implements Runnable {

	CastleSiege cs;

	CapturePoint cp;

	Location loc;

	int timeleft = 400;

	boolean finished;

	public CaptureTask(CastleSiege cs, CapturePoint cp) {

		this.cs = cs;

		this.cp = cp;

		loc = cp.locations.get(13).add(0, 1, 0);
	}

	@Override
	public void run() {

		if (cs.util.blueNearLocation(loc)) {

			timeleft--;

			if (timeleft == 0) {

				System.out.println(ChatColor.GREEN + "Blue Captured " + cp.name);

				finished = true;
			}
		}

		else {

			timeleft += 2;

			if (timeleft >= 400) {

				//TODO Fail

				finished = true;
			}
		}

		Bukkit.getScheduler().scheduleSyncDelayedTask(cs, this, 1);
	}
}
