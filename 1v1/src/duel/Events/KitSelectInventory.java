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
		Inventory kitInv = plugin.getServer().createInventory(null, 27, ChatColor.AQUA + "Kit Select");
		
		ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 0);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.setDisplayName(" ");
		filler.setItemMeta(fillerMeta);
		
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
		
		ItemStack backButton = new ItemStack(Material.REDSTONE, 1, (byte) 0);
		ItemMeta backButtonMeta = backButton.getItemMeta();
		backButtonMeta.setDisplayName(ChatColor.RED + "Back");
		backButton.setItemMeta(backButtonMeta);
		
		kitInv.setItem(0, filler);
		kitInv.setItem(1, filler);
		kitInv.setItem(2, filler);
		kitInv.setItem(3, filler);
		kitInv.setItem(4, filler);
		kitInv.setItem(5, filler);
		kitInv.setItem(6, filler);
		kitInv.setItem(7, filler);
		kitInv.setItem(8, filler);
		kitInv.setItem(9, filler);
		kitInv.setItem(17, filler);
		kitInv.setItem(18, filler);
		kitInv.setItem(19, filler);
		kitInv.setItem(20, filler);
		kitInv.setItem(21, filler);
		kitInv.setItem(22, filler);
		kitInv.setItem(23, filler);
		kitInv.setItem(24, filler);
		kitInv.setItem(25, filler);
		
		kitInv.setItem(12, noDebuff);
		kitInv.setItem(13, buildUHC);
		kitInv.setItem(14, survivalGames);
		kitInv.setItem(26, backButton);
		
		p.openInventory(kitInv);
	}
}
