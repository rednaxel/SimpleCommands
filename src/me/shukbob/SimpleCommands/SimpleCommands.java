package me.shukbob.SimpleCommands;

import java.util.logging.Logger;

import me.shukbob.SimpleCommands.commands.GM;
import me.shukbob.SimpleCommands.commands.Heal;
import me.shukbob.SimpleCommands.commands.Kill;
import me.shukbob.SimpleCommands.commands.SC;
import me.shukbob.SimpleCommands.commands.Server;
import me.shukbob.SimpleCommands.commands.Time;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleCommands extends JavaPlugin {

	public static SimpleCommands plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onDisable() {

		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled.");

	}

	@Override
	public void onEnable() {
		getConfig().addDefaults(YamlConfiguration.loadConfiguration(getClass().getResourceAsStream("config.yml");
		getConfig().options().copyDefaults(true);
		getCommand("gm").setExecutor(new GM());
		getCommand("heal").setExecutor(new Heal());
		getCommand("kill").setExecutor(new Kill());
		getCommand("sc").setExecutor(new SC());
		getCommand("server").setExecutor(new Server());
		getCommand("time").setExecutor(new Time());
	}
}