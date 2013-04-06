package tk.revolutionteam.CastleSiege.tasks;

import org.bukkit.Bukkit;
import tk.revolutionteam.CastleSiege.CastleSiege;

/**
 *
 * @author gyroninja
 */
public class KitActivateTask implements Runnable {

	CastleSiege cs;

	String name;

	public KitActivateTask(CastleSiege cs, String name) {

		this.cs = cs;

		this.name = name;
	}

	@Override
	public void run() {

		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "kitactivate " + name + " " + cs.util.md5(name));
	}
}
