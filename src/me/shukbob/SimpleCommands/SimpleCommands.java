package me.shukbob.SimpleCommands;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
		
	PluginDescriptionFile pdfFile = this.getDescription();
	this.logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " has been enabled.");
	getConfig().options().copyDefaults(true);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if(commandLabel.equalsIgnoreCase("ckill") || commandLabel.equalsIgnoreCase("kill")) {
			if (args.length == 0) {
				player.setHealth(0);
			}
			else {
				Player target = (Bukkit.getServer().getPlayer(args[0]));
				
				if (target == null) {
			           sender.sendMessage( "" + ChatColor.RED + args[0] + ChatColor.DARK_RED + " is not online!");
				}
				else {
					if(player.hasPermission("sc.command.kill")) {
						   
						target.setHealth(0);
						sender.sendMessage(ChatColor.GOLD + "You killed " + ChatColor.RED + args[0]);
						
						}else{
					   sender.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED + " You don't have permissions to use this platform!");
						}
				}
				
			}

		}
		if(commandLabel.equalsIgnoreCase("heal") || commandLabel.equalsIgnoreCase("cheal")) {
			if (args.length == 0) {
					
				if(player.hasPermission("sc.command.heal")) {
				player.setHealth(20);
				player.sendMessage(ChatColor.GOLD + "You are been healed");
				} else {
					sender.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED + " You don't have permissions to use this platform!");
				}
					
			} else {
				
				if(player.hasPermission("sc.command.heal.other")) {
					Player target = (Bukkit.getServer().getPlayer(args[0]));
					if (target == null) {
				           sender.sendMessage( "" + ChatColor.RED + args[0] + ChatColor.DARK_RED + " is not online!");
					}
					else {
						target.setHealth(20);
						target.sendMessage(ChatColor.GOLD + "You are been healed by " + ChatColor.RED + player.getName() );
					}
					
				}
			}
			
		
		}
		if(commandLabel.equalsIgnoreCase("tgm") || commandLabel.equalsIgnoreCase("ctgm")) {
			
			GameMode gm = player.getGameMode();

			if(player.hasPermission("sc.command.tgm")) {
			 
			if (gm == GameMode.CREATIVE){
			player.setGameMode(GameMode.SURVIVAL);
			 
			} else if (gm == GameMode.SURVIVAL){
			player.setGameMode(GameMode.CREATIVE);
			}
			} else {
				
				sender.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED + " You don't have permissions to use this platform!");
			}

			}
		if(commandLabel.equalsIgnoreCase("time")) {
			if(player.hasPermission("sc.command.time")) {
			if(args[0].equalsIgnoreCase("day")) {
				world.setTime(0);
	        	Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "The time was set to day!");
			} else if (args[0].equalsIgnoreCase("night")) {
				world.setTime(13000);
				Bukkit.broadcastMessage(ChatColor.AQUA + "The time was set to night!");
			} else {
				sender.sendMessage(ChatColor.DARK_GREEN + "Usage: /time (day/night)");
			}
			} else {
				sender.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED + " You don't have permissions to use this platform!");
			}
			
		}
		if(commandLabel.equalsIgnoreCase("server")) {
			if(player.hasPermission("sc.server")) {
			if(args[0].equalsIgnoreCase("stop")) {
				Bukkit.broadcastMessage(ChatColor.DARK_RED + "Server is stopping by " + player.getName());
				world.save();
				Bukkit.shutdown();
			} else if(args[0].equalsIgnoreCase("ping")) {
				sender.sendMessage(getConfig().getString("ping"));
			}
			} else {
				sender.sendMessage(ChatColor.DARK_AQUA + "[SC]" + ChatColor.RED + " You don't have permissions to use this platform!");
			}
		}

		return false; } }