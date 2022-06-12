package duel.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import duel.Main.Main;
import net.md_5.bungee.api.ChatColor;

public class MapSelectInventory implements Listener
{
	Main plugin = Main.getPlugin(Main.class);
	
	public void mapInventory(Player p)
	{
		Inventory mapInv = plugin.getServer().createInventory(null, 9, ChatColor.AQUA + "Map Select");
		
		ItemStack desertMap = new ItemStack(Material.SAND, 1, (byte) 0);
		ItemMeta desertMapMeta = desertMap.getItemMeta();
		desertMapMeta.setDisplayName(ChatColor.YELLOW + "Desert Map");
		desertMap.setItemMeta(desertMapMeta);
		
		ItemStack forestMap = new ItemStack(Material.SAPLING, 1, (byte) 0);
		ItemMeta forestMapMeta = forestMap.getItemMeta();
		forestMapMeta.setDisplayName(ChatColor.YELLOW + "Forest Map");
		forestMap.setItemMeta(forestMapMeta);
		
		ItemStack plainsMap = new ItemStack(Material.GRASS, 1, (byte) 0);
		ItemMeta plainsMapMeta = plainsMap.getItemMeta();
		plainsMapMeta.setDisplayName(ChatColor.YELLOW + "Plains Map");
		plainsMap.setItemMeta(plainsMapMeta);
		
		mapInv.setItem(3, plainsMap);
		mapInv.setItem(4, forestMap);
		mapInv.setItem(5, desertMap);
		
		p.openInventory(mapInv);
	}
}
