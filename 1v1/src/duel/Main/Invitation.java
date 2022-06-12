package duel.Main;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import duel.Events.MapSelectInventory;

public class Invitation implements Listener
{
	public static HashMap<UUID, UUID> pendingInvite = new HashMap<UUID, UUID>();
	public static HashMap<UUID, UUID> inDuel = new HashMap<UUID, UUID>();
	public static HashMap<UUID, Integer> selectedMap = new HashMap<UUID, Integer>();
	public static HashMap<UUID, Integer> selectedKit = new HashMap<UUID, Integer>();
	
	Main plugin = Main.getPlugin(Main.class);
	
	public void onInvite(Player player, Player target)
	{
		// First we are going to let the command sender (the "player" variable) pick a map and the kit they want.
		// If the player completes this then we will send the target an invitation message where they can accept
		// the duel or not.
		
		MapSelectInventory map = new MapSelectInventory();
		map.mapInventory(player);
	}
	
	public void setMap(Player player, int map)
	{
		// If desertmap we put a 1, if forestmap we put a 2, and if plainsmap we put a 3.
		
		selectedMap.put(player.getUniqueId(), map);
	}
	
	public void setKit(Player player, int kit)
	{
		// If nodebuff we put a 1, if builduhc we put a 2, and if survivalgames we put a 3.
		
		selectedKit.put(player.getUniqueId(), kit);
	}
	
	public void sendInvite(Player player, Player target)
	{
		
	}
}
