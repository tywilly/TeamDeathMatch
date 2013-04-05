package tk.revolutionteam.CastleSiege;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author gyroninja
 */
public class CastleSiege extends JavaPlugin {

	CSListener csListener = new CSListener(this);

	Teams teams = new Teams();

	CapturePoints cps = new CapturePoints();

	public Util util = new Util(this);

	@Override
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(csListener, this);
	}
}
