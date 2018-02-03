package me.draeprogs.customcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.draeprogs.customcommands.Main;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor{
	private Main plugin = Main.getPlugin(Main.class);

	String message = plugin.getConfig().getString("discord.message");

	public Commands(Main passedPlugin) {
		this.plugin = passedPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if(args.length == 1) {
			if (sender instanceof Player) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			}
			else {
				sender.sendMessage("Not avaliable in console");
			}
		}
		

		return false;
	}

}