package me.matthijs110.DwarvenLockup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ShopTP implements CommandExecutor, Listener {
	
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		Location cshop = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location bshop = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location ashop = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		
		if (cmd.getName().equalsIgnoreCase("shop")) {
			if (sender.hasPermission("shop.teleport")) {
				if (sender.hasPermission("shop.teleport.c")) {
					player.teleport(cshop);
					player.sendMessage(ChatColor.GREEN + "Teleporting to the " + ChatColor.GRAY + "C Shop");
				}
				if (sender.hasPermission("shop.teleport.b")) {
					player.teleport(bshop);
					player.sendMessage(ChatColor.GREEN + "Teleporting to the " + ChatColor.GRAY + "B Shop");
				}
				if (sender.hasPermission("shop.teleport.a")) {
					player.teleport(ashop);
					player.sendMessage(ChatColor.GREEN + "Teleporting to the " + ChatColor.GRAY + "A Shop");
				}
			} else {
				player.sendMessage(ChatColor.RED + "You don't have enough permissions!");
			}
		}
		return false;
	}

}
