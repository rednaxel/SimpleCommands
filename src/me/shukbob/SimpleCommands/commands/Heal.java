package me.shukbob.SimpleCommands.commands;

import me.shukbob.SimpleCommands.SCCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal extends SCCommand {

	@Override
	public void run(CommandSender s, String[] args) {
		if (!(s instanceof Player)) {
			return;
		}
		Player player = (Player) s;
		if (args.length == 0) {

			if (player.hasPermission("sc.command.heal")) {
				player.setHealth(20);
				player.sendMessage(ChatColor.GOLD + "You are been healed");
			} else {
				s.sendMessage(ChatColor.DARK_AQUA
						+ "[SC]"
						+ ChatColor.RED
						+ " You don't have permissions to use this platform!");
			}

		} else {

			if (player.hasPermission("sc.command.heal.other")) {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				if (target == null) {
					s.sendMessage("" + ChatColor.RED + args[0]
							+ ChatColor.DARK_RED + " is not online!");
				} else {
					target.setHealth(20);
					target.sendMessage(ChatColor.GOLD
							+ "You are been healed by " + ChatColor.RED
							+ player.getName());
				}

			}
		}

	}

}
