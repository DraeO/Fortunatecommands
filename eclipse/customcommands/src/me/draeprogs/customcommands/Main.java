package me.draeprogs.customcommands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.draeprogs.customcommands.broadcaster.Messager;
import me.draeprogs.customcommands.commands.Commands;
import me.draeprogs.customcommands.commands.ConfigManager;
import me.draeprogs.customcommands.commands.store;
import me.draeprogs.customcommands.commands.website;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{
	private ConfigManager cfgm;

	public FileConfiguration cfg;
	public File configfile;
	
	Messager messager;

	public void onEnable() {
		
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();

		this.getLogger().info("(!) Draeprogs plugin Enabled");
		this.getCommand("discord").setExecutor(new Commands(this));
		this.getCommand("website").setExecutor(new website(this));
		this.getCommand("store").setExecutor(new store(this));

		int delay = this.getConfig().getInt("broadcaster.delay");
		boolean bcenabled = this.getConfig().getBoolean("broadcaster.enabled");

		messager = new Messager(this);
		if (bcenabled == true) {
			messager.runTaskTimer(this, 0, delay * 20 * 60);
		}
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fortunatecommands")) {
			
			Player player = (Player) sender;
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("version")) {
					
					if (sender instanceof Player) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5FortunateCommands Version: &a1.2.0"));
					}
				}
			}
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5FortunateCommands Version: &a1.2.0"));
			}
			
			
			configfile = new File(getDataFolder(), "config.yml");
			
			//cfg = YamlConfiguration.loadConfiguration(configfile);
			saveDefaultConfig();
		}

		return true;
	}

	public void onDisable() {
		this.getLogger().info("(!) Draeprogs plugin Disabled");
	}

	public void loadconfigManager() {
		cfgm = new ConfigManager();
		cfgm.setup();
		cfgm.saveConfig();
		cfgm.reloadConfig();
	}

	public void loadconfig() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}

}
