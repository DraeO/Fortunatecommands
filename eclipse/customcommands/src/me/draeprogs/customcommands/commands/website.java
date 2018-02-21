package me.draeprogs.customcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.draeprogs.customcommands.Main;
import net.md_5.bungee.api.ChatColor;

public class website implements CommandExecutor{
	private Main plugin = Main.getPlugin(Main.class);
	
	String message = plugin.getConfig().getString("website.message");

	public website(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if (sender instanceof Player) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
		}
		else {
		}

		return false;
	}

}
