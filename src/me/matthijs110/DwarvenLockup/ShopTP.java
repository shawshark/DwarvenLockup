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

		Location cshop = new Location (Bukkit.getServer().getWorld("Prison"), -177.6155497683226, 60.0 ,-149.52516112130263, -269, 5);
		Location bshop = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location ashop = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);


		if (sender.hasPermission("shop.teleport") && cmd.getName().equalsIgnoreCase("shop")) {
			if (args.length == 0 || (args.length > 1)) {
				player.sendMessage(ChatColor.GREEN + "Usage: /shop " + ChatColor.GRAY + "<Shopblock>");
				return true;
			}
			if (sender.hasPermission("shop.teleport.c") && (args[0].equals("C") || (args[0].equals("c")))) {
				player.teleport(cshop);
				player.sendMessage(ChatColor.GREEN + "Teleporting to the " + ChatColor.GRAY + "C " + ChatColor.GREEN + "Shop");
			}
			if (sender.hasPermission("shop.teleport.b") && (args[0].equals("B") || (args[0].equals("b")))) {
				player.teleport(bshop);
				player.sendMessage(ChatColor.GREEN + "Teleporting to the " + ChatColor.GRAY + "B " + ChatColor.GREEN + "Shop");
			}
			if (sender.hasPermission("shop.teleport.a") && (args[0].equals("A") || (args[0].equals("a")))) {
				player.teleport(ashop);
				player.sendMessage(ChatColor.GREEN + "Teleporting to the " + ChatColor.GRAY + "A " + ChatColor.GREEN + "Shop");
			}
		} else {
			player.sendMessage(ChatColor.RED + "You don't have enough permissions!");
		}
		return false;
	}
}
