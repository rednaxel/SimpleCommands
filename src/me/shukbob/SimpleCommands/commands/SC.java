package me.shukbob.SimpleCommands.commands;

import me.shukbob.SimpleCommands.SCCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class SC extends SCCommand {

	@Override
	public void run(CommandSender s, String[] args) {
		if (!(s instanceof Player)) {
			return;
		}
		PluginDescriptionFile pdfFile = getPlugin().getDescription();
		s.sendMessage("This server is running SimpleCommands v"
				+ pdfFile.getVersion() + ". Made by Shuk and Delocaz");

	}

}
