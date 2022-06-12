package duel.Main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import duel.Events.KitSelectListener;
import duel.Events.MapSelectListener;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.util.org.apache.commons.io.FileUtils;

public class Main extends JavaPlugin implements Listener 
{
	public void onEnable() 
	{
		Commands command = new Commands();
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "----------------------");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  1v1 System Enabled  ");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "----------------------");
		
		// Set the "/duel" command's executor to the Commands class.
		
		getServer().getPluginCommand(Commands.duel).setExecutor(command);
		
		// Register the events in the Map and Kit listener classes.
		
		this.getServer().getPluginManager().registerEvents(new MapSelectListener(), this);
		this.getServer().getPluginManager().registerEvents(new KitSelectListener(), this);
		
		createMaps();
	}

	public void onDisable() 
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "  1v1 System Disabled  ");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------");
	}
	
	public void createMaps()
	{
		WorldCreator desert, forest, plains;
		World desertmap, forestmap, plainsmap;
		
		if(!FileUtils.getFile("desertMap").exists())
		{
			desert = new WorldCreator("desertMap");
			desert.type(WorldType.FLAT);
			desertmap = desert.createWorld();
		}
		
		if(!FileUtils.getFile("forestMap").exists())
		{
			forest = new WorldCreator("forestMap");
			forest.type(WorldType.FLAT);
			forestmap = forest.createWorld();
		}
		
		if(!FileUtils.getFile("plainsMap").exists())
		{
			plains = new WorldCreator("plainsMap");
			plains.type(WorldType.FLAT);
			plainsmap = plains.createWorld();
		}
	}
}
