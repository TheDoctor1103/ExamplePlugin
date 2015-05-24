package com.herp.derp;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.herp.derp.commands.CommandHeal;

public class Main
	extends JavaPlugin
{
	Main plugin;
	Logger logger = this.getLogger();
	PluginDescriptionFile pdffile = this.getDescription();
	
	@Override
	public void onEnable()
	{
		logger.info(pdffile.getName() + " v" + pdffile.getVersion() + " has been enabled!");
		
		getCommand("heal").setExecutor(new CommandHeal());
	}
	
	@Override
	public void onDisable()
	{
		logger.info(pdffile.getName() + " has been disabled!");
	}
}