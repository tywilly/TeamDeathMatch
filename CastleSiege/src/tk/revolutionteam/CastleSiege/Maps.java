package tk.revolutionteam.CastleSiege;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author gyroninja
 */
public class Maps {

	CastleSiege cs;

	HashMap<String, Map> maps = new HashMap<>();

	String currentMap = "world";

	String previousMap = "world";

	public Maps(CastleSiege cs) {

		this.cs = cs;
	}

	public void setMap(String name) {

		previousMap = currentMap;

		currentMap = name;

		switchWorlds();
	}

	public void switchWorlds() {

		cs.mv.getCore().getMVWorldManager().loadWorld(currentMap);

		for (Player p : Bukkit.getWorld(previousMap).getPlayers()) {

			p.teleport(Bukkit.getWorld(currentMap).getSpawnLocation());
		}

		Bukkit.unloadWorld(previousMap, false);

		cs.mv.getCore().getMVWorldManager().getUnloadedWorlds().add(previousMap);

		CSWorldManager worldManager = new CSWorldManager(cs.mv.getCore().getMVWorldManager());

		worldManager.unload(previousMap);
	}
}
