package duel.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import duel.Main.Invitation;
import net.md_5.bungee.api.ChatColor;

public class MapSelectListener implements Listener
{
	private Invitation invitation = new Invitation();
	private KitSelectInventory kitInventory = new KitSelectInventory();
	
	@EventHandler
	public void onMapInventory(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		
		Inventory mapInv = e.getInventory();
		ItemStack clickedItem = e.getCurrentItem();
		
		if(mapInv == null)
		{
			return;
		}
		else if(mapInv.getName().equals(ChatColor.AQUA + "Map Select"))
		{
			e.setCancelled(true);
			
			if(clickedItem == null || !clickedItem.hasItemMeta())
			{
				return;
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Desert Map"))
			{
				p.closeInventory();
				
				// Set the map, then open the "Kit Select" inventory.
				
				invitation.setMap(p, 1);
				kitInventory.kitInventory(p);
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Forest Map"))
			{
				p.closeInventory();
				
				// Set the map, then open the "Kit Select" inventory.
				
				invitation.setMap(p, 2);
				kitInventory.kitInventory(p);
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Plains Map"))
			{
				p.closeInventory();
				
				// Set the map, then open the "Kit Select" inventory.
				
				invitation.setMap(p, 3);
				kitInventory.kitInventory(p);
			}
		}
	}
}
