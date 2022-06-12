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
		Inventory mapInv = plugin.getServer().createInventory(null, 27, ChatColor.AQUA + "Map Select");
		
		ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 0);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.setDisplayName(" ");
		filler.setItemMeta(fillerMeta);
		
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
		
		mapInv.setItem(0, filler);
		mapInv.setItem(1, filler);
		mapInv.setItem(2, filler);
		mapInv.setItem(3, filler);
		mapInv.setItem(4, filler);
		mapInv.setItem(5, filler);
		mapInv.setItem(6, filler);
		mapInv.setItem(7, filler);
		mapInv.setItem(8, filler);
		mapInv.setItem(9, filler);
		mapInv.setItem(17, filler);
		mapInv.setItem(18, filler);
		mapInv.setItem(19, filler);
		mapInv.setItem(20, filler);
		mapInv.setItem(21, filler);
		mapInv.setItem(22, filler);
		mapInv.setItem(23, filler);
		mapInv.setItem(24, filler);
		mapInv.setItem(25, filler);
		mapInv.setItem(26, filler);
		
		mapInv.setItem(12, plainsMap);
		mapInv.setItem(13, forestMap);
		mapInv.setItem(14, desertMap);
		
		p.openInventory(mapInv);
	}
}
