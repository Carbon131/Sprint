package com.Carbon131.Sprint;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
 
public class Sprint extends JavaPlugin
{
	private final SprintPlayerListener playerListener = new SprintPlayerListener(this);
	public static HashMap<Player, Double> players = new HashMap<Player, Double>();
	public static HashMap<Player, Boolean> status = new HashMap<Player, Boolean>();
	public static PermissionHandler Permissions;
    public static double speed;
    public static double energylostpersecond;
    public static double energygainedpersecond;
    public static boolean highjumpenabled;
    public static boolean requiresitem;
    public static boolean requirescommandenabled;
    public static boolean helditemenabled;
    public static int helditemid;
    public static int itemid;
    public static int messagesinterval;
    public static String energygainedcolor;
    public static String energylostcolor;
   
    public void checkVersion() throws Exception {
    	URL sprint = new URL("http://sprint.dynamicminecraft.com");
    	BufferedReader in = new BufferedReader(new InputStreamReader(sprint.openStream()));
    	String version = in.readLine();
    	in.close();
		PluginDescriptionFile pdfFile = getDescription();
		if (!pdfFile.getVersion().equals(version))
		{
			System.out.println("[Sprint] New version (v" + version + ") is available for download!");
		}
    }
    
	private void setupPermissions() {
		Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");

		if (Sprint.Permissions == null) 
		{
			if (test != null) {
				Sprint.Permissions = ((Permissions)test).getHandler();
			} else {
				System.out.println("[Sprint] Permissions plugin not found, defaulting to ops.txt.");
			}
		}
	}
	
	public void setup() {
        if (!new File("plugins/Sprint").exists())
        {
        	new File("plugins/Sprint").mkdir();
        }
       	if (!new File("plugins/Sprint/config.yml").exists())
        {
        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
        	config.load();
        	config.setProperty("options.speed", .6);
        	config.setProperty("options.energy-lost-per-second", 1);
        	config.setProperty("options.energy-gained-per-second", 1);
        	config.setProperty("options.high-jump-enabled", false);
        	config.setProperty("options.requires-command-enabled", false);
        	config.setProperty("requires-item.enabled", false);
        	config.setProperty("requires-item.item-id", 301);
        	config.setProperty("held-item.enabled", false);
        	config.setProperty("held-item.item-id", 0);
        	config.setProperty("messages.interval", 5);
        	config.setProperty("messages.energy-gained-color", "f");
        	config.setProperty("messages.energy-lost-color", "f");
        	config.save();
        	speed = config.getDouble("options.speed", .6);
        	energylostpersecond = config.getDouble("options.energy-lost-per-second", 1);
        	energygainedpersecond = config.getDouble("options.energy-gained-per-second", 1);
        	highjumpenabled = config.getBoolean("options.high-jump-enabled", false);
        	requirescommandenabled = config.getBoolean("options.requires-command-enabled", false);
        	requiresitem = config.getBoolean("requires-item.enabled", false);
        	itemid = config.getInt("requires-item.item-id", 301);
        	helditemenabled = config.getBoolean("held-item.enabled", false);
        	helditemid = config.getInt("held-item.item-id", 0);
        	messagesinterval = config.getInt("messages.interval", 5);
        	energygainedcolor = config.getString("messages.energy-gained-color", "f");
        	energylostcolor = config.getString("messages.energy-lost-color", "f");

        }
        else
        {
        	Configuration config = new Configuration(new File("plugins/Sprint", "config.yml"));
        	config.load();
        	speed = config.getDouble("options.speed", .6);
        	energylostpersecond = config.getDouble("options.energy-lost-per-second", 1);
        	energygainedpersecond = config.getDouble("options.energy-gained-per-second", 1);
        	highjumpenabled = config.getBoolean("options.high-jump-enabled", false);
        	requirescommandenabled = config.getBoolean("options.requires-command-enabled", false);
        	requiresitem = config.getBoolean("requires-item.enabled", false);
        	itemid = config.getInt("requires-item.item-id", 301);
        	helditemenabled = config.getBoolean("held-item.enabled", false);
        	helditemid = config.getInt("held-item.item-id", 0);
        	messagesinterval = config.getInt("messages.interval", 5);
        	energygainedcolor = config.getString("messages.energy-gained-color", "f");
        	energylostcolor = config.getString("messages.energy-lost-color", "f");
        }
	}
 
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
		PluginDescriptionFile pdfFile = getDescription();
		System.out.println("[" + pdfFile.getName() + "] v" + pdfFile.getVersion() + " is enabled!");
		setupPermissions();
		setup();
		getCommand("sprint").setExecutor(new SprintCommands(this));
		try {
			checkVersion();
		} catch (Exception e) {
		}
	}
	
    public void onDisable()
	{
	}
}
