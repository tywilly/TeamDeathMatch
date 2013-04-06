package tk.revolutionteam.CastleSiege;

import com.onarandombox.MultiverseCore.api.MVPlugin;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import yt.codebukkit.scoreboardapi.Scoreboard;
import yt.codebukkit.scoreboardapi.Scoreboard.Type;
import yt.codebukkit.scoreboardapi.ScoreboardAPI;

/**
 *
 * @author gyroninja
 */
public class CastleSiege extends JavaPlugin {

	CSListener csListener = new CSListener(this);

	public Teams teams = new Teams();

	CapturePoints cps = new CapturePoints();

	public Util util = new Util(this);

	public Scoreboard scoreboard;

	MVPlugin mv;

	Maps maps = new Maps(this);

	@Override
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(csListener, this);

		cps.capturePoints.put("TEST", new CapturePoint(this, new Location(Bukkit.getWorld("world"), -54, 65, 881), "TEST"));

		scoreboard = ScoreboardAPI.getInstance().createScoreboard("CastleBoard", 10);

		scoreboard.setType(Type.SIDEBAR);

		scoreboard.setScoreboardName("State");

		mv = (MVPlugin) Bukkit.getPluginManager().getPlugin("Multiverse-Core");

		maps.setMap("Castle");
	}
}
