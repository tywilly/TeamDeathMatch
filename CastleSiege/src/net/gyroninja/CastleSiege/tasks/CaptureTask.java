package net.gyroninja.CastleSiege.tasks;

import net.gyroninja.CastleSiege.CapturePoint;
import net.gyroninja.CastleSiege.CastleSiege;
import net.gyroninja.CastleSiege.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author gyroninja
 */
public class CaptureTask implements Runnable {

	CastleSiege cs;

	Location loc;

	int timeleft = 400;

	boolean finished;

	public CaptureTask(CastleSiege cs, CapturePoint cp) {

		this.cs = cs;

		loc = cp.locations.get(13).add(0, 1, 0);
	}

	@Override
	public void run() {

		if (cs.util.blueNearLocation(loc)) {

			timeleft--;

			if (timeleft == 0) {

				//TODO Success

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
