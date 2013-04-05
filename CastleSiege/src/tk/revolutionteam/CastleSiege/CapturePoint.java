package tk.revolutionteam.CastleSiege;

import java.util.ArrayList;
import org.bukkit.Location;

/**
 *
 * @author gyroninja
 */
public class CapturePoint {

	public ArrayList<Location> locations = new ArrayList<>();;

	String name = "Default Name";

	public CapturePoint(Location loc) {

		for (int x = loc.getBlockX() - 2; x <= loc.getBlockX() + 2; x++) {

			for (int z = loc.getBlockZ() - 2; x <= loc.getBlockZ() + 2; x++) {

				locations.add(loc.add(x, 0, z));
			}
		}
	}

	public void setName(String name) {

		this.name = name;
	}
}
