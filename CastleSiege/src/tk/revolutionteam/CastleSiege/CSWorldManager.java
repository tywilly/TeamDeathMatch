package tk.revolutionteam.CastleSiege;

import com.onarandombox.MultiverseCore.MVWorld;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gyroninja
 */
public class CSWorldManager {

	MVWorldManager mvWorldManager;

	public CSWorldManager(MVWorldManager mvWorldManager) {

		this.mvWorldManager = mvWorldManager;
	}

	public void unload(String world) throws IllegalArgumentException {
		try {
			Field worldsField = WorldManager.class.getDeclaredField("worlds");

			worldsField.setAccessible(true);

			HashMap<String, MVWorld> worlds = (HashMap<String, MVWorld>) worldsField.get(mvWorldManager);

			worlds.remove(world);
		}

		catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {

			System.out.println("Reflection Error");
		}
	}
}
