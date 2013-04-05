package tk.revolutionteam.CastleSiege;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author gyroninja
 */
public class Util {

	CastleSiege cs;

	public Util(CastleSiege cs) {

		this.cs = cs;
	}

	public boolean blueNearLocation(Location loc) {

		for (Player p : Bukkit.getOnlinePlayers()) {

			if (cs.teams.blue.contains(p.getName())) {

				for (int x = loc.getBlockX() - 2; x <= loc.getBlockX() + 2; x++) {

					for (int z = loc.getBlockZ() - 2; x <= loc.getBlockZ() + 2; x++) {

						if (p.getLocation().equals(loc.add(x, 0, z))) {

							return true;
						}
					}
				}
			}
		}

		return false;
	}
}
