package duel.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import duel.Main.Invitation;
import net.md_5.bungee.api.ChatColor;


public class KitSelectListener implements Listener
{
	private Invitation invitation = new Invitation();
	private MapSelectInventory mapInv = new MapSelectInventory();
	
	@EventHandler
	public void onKitInventory(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		
		Inventory kitInv = e.getInventory();
		ItemStack clickedItem = e.getCurrentItem();
		
		if(kitInv == null)
		{
			return;
		}
		else if(kitInv.getName().equals(ChatColor.AQUA + "Kit Select"))
		{
			e.setCancelled(true);
			
			if(clickedItem == null || !clickedItem.hasItemMeta())
			{
				return;
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "No Debuff"))
			{
				p.closeInventory();
				
				invitation.setKit(p, 1);
				invitation.sendInvite(p, Bukkit.getPlayer(invitation.getPendingInviteTarget(p)));
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "BuildUHC"))
			{
				p.closeInventory();
				
				invitation.setKit(p, 2);
				invitation.sendInvite(p, Bukkit.getPlayer(invitation.getPendingInviteTarget(p)));
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Survival Games"))
			{
				p.closeInventory();
				
				invitation.setKit(p, 3);
				invitation.sendInvite(p, Bukkit.getPlayer(invitation.getPendingInviteTarget(p)));
			}
			else if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.RED + "Back"))
			{
				// Send the player back into the Map Select inventory.
				
				mapInv.mapInventory(p);
			}
		}
	}
}
