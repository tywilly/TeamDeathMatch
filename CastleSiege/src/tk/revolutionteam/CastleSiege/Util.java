package tk.revolutionteam.CastleSiege;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

				for (int x = -2; x <= 2; x++) {

					for (int z = -2; z <= 2; z++) {

						if (sameLoc(p.getLocation(), loc.clone().add(x, 1, z))) {

							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public boolean sameLoc(Location loc, Location loc2) {

		if (loc.getBlockX() == loc2.getBlockX() && loc.getBlockY() == loc2.getBlockY() && loc.getBlockZ() == loc2.getBlockZ()) {

			return true;
		}

		return false;
	}

	public String md5(String s) {

		String hash = "";

		try {

			byte[] data = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < data.length; i++) {

				sb.append(Integer.toHexString((data[i] & 0xFF) | 0x100).substring(1, 3));
			}

			hash = sb.toString();
		}

		catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {

			System.out.println("MD5 not supported");
		}

		return hash;
	}
}
