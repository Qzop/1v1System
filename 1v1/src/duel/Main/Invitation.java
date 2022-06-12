package duel.Main;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import duel.Events.MapSelectInventory;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Invitation implements Listener
{
	private static HashMap<UUID, UUID> pendingInvite = new HashMap<UUID, UUID>();
	private static HashMap<UUID, UUID> inDuel = new HashMap<UUID, UUID>();
	private static HashMap<UUID, Integer> selectedMap = new HashMap<UUID, Integer>();
	private static HashMap<UUID, Integer> selectedKit = new HashMap<UUID, Integer>();
	
	private String duelPrefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Duel" + ChatColor.GRAY + "]";
	
	Main plugin = Main.getPlugin(Main.class);
	
	public void onInvite(Player player, Player target)
	{
		// First we are going to let the command sender (the "player" variable) pick a map and the kit they want.
		// If the player completes this then we will send the target an invitation message where they can accept
		// the duel or not.
		
		MapSelectInventory map = new MapSelectInventory();
		map.mapInventory(player);
		pendingInvite.put(player.getUniqueId(), target.getUniqueId());
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
	
	public int getMap(Player player)
	{
		return selectedMap.get(player.getUniqueId());
	}
	
	public int getKit(Player player)
	{
		return selectedKit.get(player.getUniqueId());
	}
	
	public UUID getPendingInviteTarget(Player player)
	{
		return pendingInvite.get(player.getUniqueId());
	}
	
	public void sendInvite(Player player, Player target)
	{
		String map = "";
		String kit = "";
		
		player.sendMessage(duelPrefix + ChatColor.GREEN + " You have successfully sent a duel request to " + ChatColor.YELLOW + target.getDisplayName() + ChatColor.GREEN + ".");
		
		if(getMap(player) == 1)
		{
			map = "" + ChatColor.YELLOW + "Desert " + ChatColor.YELLOW + "Map";
		}
		else if(getMap(player) == 2)
		{
			map = "" + ChatColor.YELLOW +  "Forest " + ChatColor.YELLOW + "Map";
		}
		else if(getMap(player) == 3)
		{
			map = "" + ChatColor.YELLOW +  "Plains " + ChatColor.YELLOW + "Map";
		}
		
		if(getKit(player) == 1)
		{
			kit = "" + ChatColor.YELLOW + "No " + ChatColor.YELLOW + "Debuff";
		}
		else if(getKit(player) == 2)
		{
			kit = "" + ChatColor.YELLOW + "BuildUHC";
		}
		else if(getKit(player) == 3)
		{
			kit = "" + ChatColor.YELLOW + "Survival" + ChatColor.YELLOW + "Games";
		}
		
		TextComponent prefix = new TextComponent(duelPrefix);
		TextComponent message = new TextComponent(ChatColor.YELLOW + " " + player.getDisplayName() + ChatColor.LIGHT_PURPLE + " has sent you a duel request on map " + map + ChatColor.LIGHT_PURPLE + " using kit " + kit + ChatColor.LIGHT_PURPLE + ". ");
		TextComponent click = new TextComponent(ChatColor.GREEN + "[Click Here]");
		TextComponent secondMessage = new TextComponent(ChatColor.LIGHT_PURPLE + " to accept the duel or use /duel accept (player).");
		
		click.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/duel accept " + player.getName()));
		click.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GREEN + "Accept Duel").create()));
		
		target.spigot().sendMessage(prefix, message, click, secondMessage);
	}
}
