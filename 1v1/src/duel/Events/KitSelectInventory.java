package duel.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import duel.Main.Main;
import net.md_5.bungee.api.ChatColor;

public class KitSelectInventory implements Listener
{
	Main plugin = Main.getPlugin(Main.class);
	
	public void kitInventory(Player p)
	{
		Inventory kitInv = plugin.getServer().createInventory(null, 9, ChatColor.AQUA + "Kit Select");
		
		Potion healingPot = new Potion(PotionType.INSTANT_HEAL, 1);
		ItemStack noDebuff = healingPot.toItemStack(1);
		ItemMeta noDebuffMeta = noDebuff.getItemMeta();
		noDebuffMeta.setDisplayName(ChatColor.YELLOW + "No Debuff");
		noDebuff.setItemMeta(noDebuffMeta);
		
		ItemStack buildUHC = new ItemStack(Material.GOLDEN_APPLE, 1, (byte) 0);
		ItemMeta buildUHCMeta = buildUHC.getItemMeta();
		buildUHCMeta.setDisplayName(ChatColor.YELLOW + "BuildUHC");
		buildUHC.setItemMeta(buildUHCMeta);
		
		ItemStack survivalGames = new ItemStack(Material.FLINT_AND_STEEL, 1, (byte) 0);
		ItemMeta survivalGamesMeta = survivalGames.getItemMeta();
		survivalGamesMeta.setDisplayName(ChatColor.YELLOW + "Survival Games");
		survivalGames.setItemMeta(survivalGamesMeta);
		
		kitInv.setItem(3, noDebuff);
		kitInv.setItem(4, buildUHC);
		kitInv.setItem(5, survivalGames);
		
		p.openInventory(kitInv);
	}
}
