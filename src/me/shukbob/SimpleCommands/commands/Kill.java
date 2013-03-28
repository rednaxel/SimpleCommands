package me.shukbob.SimpleCommands.commands;

import me.shukbob.SimpleCommands.SCCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill extends SCCommand {

	@Override
	public void run(CommandSender s, String[] args) {
		if (!(s instanceof Player)) {
			return;
		}
		Player player = (Player) s;
		if (args.length == 0) {
			player.setHealth(0);
		} else {
			Player target = (Bukkit.getServer().getPlayer(args[0]));

			if (target == null) {
				s.sendMessage("" + ChatColor.RED + args[0]
						+ ChatColor.DARK_RED + " is not online!");
			} else {
				if (player.hasPermission("sc.command.kill")) {

					target.setHealth(0);
					s.sendMessage(ChatColor.GOLD + "You killed "
							+ ChatColor.RED + args[0]);

				} else {
					s.sendMessage(ChatColor.DARK_AQUA
							+ "[SC]"
							+ ChatColor.RED
							+ " You don't have permissions to use this platform!");
				}
			}

		}
	}

}
