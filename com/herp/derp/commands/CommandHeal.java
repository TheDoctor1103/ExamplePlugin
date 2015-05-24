package com.herp.derp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandHeal 
	implements CommandExecutor 
{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		if (args.length == 0)
		{
			if (sender instanceof Player)
			{
				if (sender.hasPermission("plugin.heal") || sender.isOp())
				{
					Player player = (Player) sender;
					
					player.setHealth(20.0);
					player.setFoodLevel(20);
					player.setFireTicks(0);
					player.getActivePotionEffects().clear();
				}
			} else if (sender instanceof ConsoleCommandSender)
			{
				sender.sendMessage(ChatColor.RED + "ERROR: Please enter a player's name!");
			}
		} else if (args.length == 1)
		{
			if (sender instanceof ConsoleCommandSender)
			{
				Player target = Bukkit.getPlayer(args[0]);
				
				if (target != null)
				{
					
					target.setHealth(20.0);
					target.setFoodLevel(20);
					target.setFireTicks(0);
					target.getActivePotionEffects().clear();
				} else
				sender.sendMessage(ChatColor.RED + "ERROR: Target not found!");
			}
			else if (sender instanceof Player)
			{
				if (sender.hasPermission("plugin.heal.others") || sender.isOp())
				{
					Player target = Bukkit.getPlayer(args[0]);
					
					if (target != null)
					{
						
						target.setHealth(20.0);
						target.setFoodLevel(20);
						target.setFireTicks(0);
						target.getActivePotionEffects().clear();
					} else
					sender.sendMessage(ChatColor.RED + "ERROR: Target not found!");
				}
			}
		}
		return false;
	}

}