package me.draeprogs.customcommands.broadcaster;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import me.draeprogs.customcommands.Main;

public class Messager extends BukkitRunnable{

	//private Main plugin = Main.getPlugin(Main.class);

	private Main plugin = Main.getPlugin(Main.class);

	String prefix = plugin.getConfig().getString("broadcaster.prefix");
	String message = plugin.getConfig().getString("broadcaster.message");

	public Messager (Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {

		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
	}



}
