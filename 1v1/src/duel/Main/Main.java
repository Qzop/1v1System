package duel.Main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import duel.Events.KitSelectListener;
import duel.Events.MapSelectListener;
import net.md_5.bungee.api.ChatColor;

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
	}

	public void onDisable() 
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "  1v1 System Disabled  ");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------");
	}
	
	public void createMaps()
	{
		
	}
}
