package me.shukbob.SimpleCommands.commands;

import me.shukbob.SimpleCommands.SCCommand;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GM extends SCCommand {

	@Override
	public void run(CommandSender s, String[] args) {
		if (!(s instanceof Player)) {
			return;
		}
		Player player = (Player) s;
		GameMode gm = player.getGameMode();

		if (player.hasPermission("sc.command.tgm")) {

			if (gm == GameMode.CREATIVE) {
				player.setGameMode(GameMode.SURVIVAL);

			} else if (gm == GameMode.SURVIVAL) {
				player.setGameMode(GameMode.CREATIVE);
			}
		} else {

			s.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED
					+ " You don't have permissions to use this platform!");
		}

	}

}
