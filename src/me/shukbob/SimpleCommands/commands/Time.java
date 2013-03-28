package me.shukbob.SimpleCommands.commands;

import me.shukbob.SimpleCommands.SCCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time extends SCCommand {

	@Override
	public void run(CommandSender s, String[] args) {
		if (!(s instanceof Player)) {
			return;
		}
		Player player = (Player) s;
		if (player.hasPermission("sc.command.time")) {
			if (args[0].equalsIgnoreCase("day")) {
				player.getWorld().setTime(0);
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA
						+ "The time was set to day!");
			} else if (args[0].equalsIgnoreCase("night")) {
				player.getWorld().setTime(13000);
				Bukkit.broadcastMessage(ChatColor.AQUA
						+ "The time was set to night!");
			} else {
				s.sendMessage(ChatColor.DARK_GREEN
						+ "Usage: /time (day/night)");
			}
		} else {
			s.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED
					+ " You don't have permissions to use this platform!");
		}
	}

}
