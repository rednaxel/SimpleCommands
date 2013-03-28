package me.shukbob.SimpleCommands.commands;

import me.shukbob.SimpleCommands.SCCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Server extends SCCommand {

	@Override
	public void run(CommandSender s, String[] args) {
		if (!(s instanceof Player)) {
			return;
		}
		Player player = (Player) s;
		if (player.hasPermission("sc.server")) {
			if (args[0].equalsIgnoreCase("stop")) {
				Bukkit.broadcastMessage(ChatColor.DARK_RED
						+ "Server is stopping by " + player.getName());
				player.getWorld().save();
				Bukkit.shutdown();
			} else if (args[0].equalsIgnoreCase("ping")) {
				s.sendMessage(getPlugin().getConfig().getString("ping"));
			}
		} else {
			s.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED
					+ " You don't have permissions to use this platform!");
		}
	}

}
