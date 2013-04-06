package tk.revolutionteam.CastleSiege;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.metadata.FixedMetadataValue;

/**
 *
 * @author gyroninja
 */
public class CapturePoint {

	public String name = "Default Name";

	public boolean busy;

	public boolean capped;

	public Location center;

	public CapturePoint(CastleSiege cs, Location loc, String name) {

		center = loc;

		for (int x = loc.getBlockX() - 2; x <= loc.getBlockX() + 2; x++) {

			for (int z = loc.getBlockZ() - 2; z <= loc.getBlockZ() + 2; z++) {

				Block b = new Location(loc.getWorld(), x, loc.getBlockY(), z).getBlock();

				b.setMetadata("cp", new FixedMetadataValue(cs, name));
			}
		}

		this.name = name;
	}
}
