package duel.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class Commands implements Listener, CommandExecutor 
{
	public static String duel = "duel";
	private Invitation invite = new Invitation();

	// This entire method will be used to deal with players sending commands.

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) 
	{
		// We will only be using sender, command, and args.
		// sender is the player that used the command
		// command is the command the player gave
		// args are the arguments the player gave after the command. For example: /duel
		// (player) where (player) is the argument

		Player p = (Player) sender; // set sender to a player variable, this variable will be the person who sent the command.

		// Check if the command entered equals a specific command. In this case, we are
		// testing if the command equals "Duel"
		if (command.equalsIgnoreCase(duel)) 
		{
			// Check if there are arguments.
			// If there are no arguments or there are more than 1 argument, we throw an
			// error message to the sender.

			if (args.length == 1) 
			{
				Player target = Bukkit.getPlayer(args[0]);

				// Check if the player is online. If not, we throw an error message to the
				// sender.

				if (target == null) 
				{
					p.sendMessage(ChatColor.RED + "That player is not online!");
				} 
				else 
				{
			       // Put the command sender and the target into a HashMap for pending invites.
					
                   invite.onInvite(p, target);
				}
			} 
			else 
			{
				p.sendMessage(ChatColor.RED + "Usage: /duel (player)");
			}

		}

		return false;
	}
}
