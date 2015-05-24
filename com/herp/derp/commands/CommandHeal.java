package com.herp.derp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

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
					PotionEffect effect = (PotionEffect) player.getActivePotionEffects();
					
					player.setHealth(20.0);
					player.setFireTicks(0);
					player.removePotionEffect(effect.getType());
				}
			}
			sender.sendMessage(ChatColor.RED + "ERROR: Please specify a player's name!");
		}
		if (args.length == 1)
		{
			if (sender instanceof Server)
			{
				Player target = Bukkit.getPlayer(args[0]);
				
				if (target != null)
				{
					PotionEffect effect = (PotionEffect) target.getActivePotionEffects();
					
					target.setHealth(20.0);
					target.setFireTicks(0);
					target.removePotionEffect(effect.getType());
				}
				sender.sendMessage(ChatColor.RED + "ERROR: Target not found!");
			}
			if (sender instanceof Player)
			{
				if (sender.hasPermission("plugin.heal.others") || sender.isOp())
				{
					Player target = Bukkit.getPlayer(args[0]);
					
					if (target != null)
					{
						PotionEffect effect = (PotionEffect) target.getActivePotionEffects();
						
						target.setHealth(20.0);
						target.setFireTicks(0);
						target.removePotionEffect(effect.getType());
					}
					sender.sendMessage(ChatColor.RED + "ERROR: Target not found!");
				}
			}
		}
		return false;
	}

}
