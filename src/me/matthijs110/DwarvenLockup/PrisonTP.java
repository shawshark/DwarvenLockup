package me.matthijs110.DwarvenLockup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PrisonTP extends JavaPlugin implements CommandExecutor {

	// Prison commands
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		Location cprison = new Location (Bukkit.getServer().getWorld("world"), 3284.48976, 63, -418.49132, 359, -3);
		Location bprison = new Location (Bukkit.getServer().getWorld("world"), 3284.48976, 70, -418.49132, 359, -3);
		Location aprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location eliteprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location masterprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location guardprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location riotprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location officerprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location captainprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);
		Location staffprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0 ,0 ,0, 0);

		if (sender.hasPermission("prisontp.use")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.GREEN + "Usage: /prison " + ChatColor.GRAY + "<prison>");
			}
			// C Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("C"))) {
				if (sender.hasPermission("prisontp.c")) {
					p.teleport(cprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.GRAY + "Prison C");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// B Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("B"))) {
				if (sender.hasPermission("prisontp.b")) {
					p.teleport(bprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.GRAY + "Prison B");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			} 	
			// A Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("A"))) {
				if (sender.hasPermission("prisontp.a")) {
					p.teleport(aprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.GRAY + "Prison A");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Elite Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Elite"))) {
				if (sender.hasPermission("prisontp.elite")) {
					p.teleport(eliteprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Elite Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Master Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Master"))) {
				if (sender.hasPermission("prisontp.master")) {
					p.teleport(masterprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Master Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Guard Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Guard"))) {
				if (sender.hasPermission("prisontp.guard")) {
					p.teleport(guardprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Guard Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Riot Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Riot"))) {
				if (sender.hasPermission("prisontp.riot")) {
					p.teleport(riotprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Riot Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Officer Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Officer"))) {
				if (sender.hasPermission("prisontp.officer")) {
					p.teleport(officerprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Officer Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Captain Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Captain"))) {
				if (sender.hasPermission("prisontp.captain")) {
					p.teleport(captainprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Captain Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Staff Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("Staff"))) {
				if (sender.hasPermission("prisontp.staff")) {
					p.teleport(staffprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the" + ChatColor.GRAY + "Staff Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			if (args.length > 1) {
				if (sender.hasPermission("prisontp.use")) {
					p.sendMessage(ChatColor.GREEN + "Usage: /block " + ChatColor.GRAY + "<prison>");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
		} else {
			p.sendMessage(ChatColor.RED + "You don't have permissons!");
		}
		return false;
	}
}
