package me.shukbob.SimpleCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class SCCommand implements CommandExecutor {
	public SCCommand() {
	}
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		return false;
	}
	public SimpleCommands getPlugin() {
		return (SimpleCommands) Bukkit.getPluginManager().getPlugin("SimpleCommands");
	}
	public abstract void run(CommandSender s, String[] args);
}
