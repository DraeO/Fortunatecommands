package me.draeprogs.customcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.draeprogs.customcommands.broadcaster.Messager;
import me.draeprogs.customcommands.commands.Commands;
import me.draeprogs.customcommands.commands.ConfigManager;
import me.draeprogs.customcommands.commands.store;
import me.draeprogs.customcommands.commands.website;

public class Main extends JavaPlugin{
	private ConfigManager cfgm;


	Messager messager;

	public void onEnable() {

		loadconfigManager();

		this.getLogger().info("(!) Draeprogs plugin Enabled");
		this.getCommand("discord").setExecutor(new Commands(this));
		this.getCommand("website").setExecutor(new website(this));
		this.getCommand("store").setExecutor(new store(this));
		this.getCommand("draeprogs").setExecutor(new store(this));

		int delay = this.getConfig().getInt("broadcaster.delay");

		messager = new Messager(this);
		messager.runTaskTimer(this, 0, delay * 20);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


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
		saveConfig();
	}

}
