package me.matthijs110.DwarvenLockup.Teleports;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrisonTP implements CommandExecutor {

	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		Location cprison = new Location (Bukkit.getServer().getWorld("Prison"), 3284.48976, 63, -418.49132, 359, -3);
		Location bprison = new Location (Bukkit.getServer().getWorld("Prison"), 0, 0, 0, 0, 0);
		Location aprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location eliteprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location masterprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location guardprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location riotprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location officerprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location captainprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location staffprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location dealerprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location druglordprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);
		Location sgtprison = new Location (Bukkit.getServer().getWorld(" "), 0, 0, 0, 0, 0);

		if (sender.hasPermission("prisontp.use") && cmd.getName().equalsIgnoreCase("prison")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.GREEN + "Usage: /prison " + ChatColor.GRAY + "<prison>");
			}
			// C Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("c"))) {
				if (sender.hasPermission("prisontp.c")) {
					p.teleport(cprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.GRAY + "Prison C");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// B Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("b"))) {
				if (sender.hasPermission("prisontp.b")) {
					p.teleport(bprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.GRAY + "Prison B");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			} 	
			// A Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("a"))) {
				if (sender.hasPermission("prisontp.a")) {
					p.teleport(aprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.GRAY + "Prison A");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Elite Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("elite"))) {
				if (sender.hasPermission("prisontp.elite")) {
					p.teleport(eliteprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Elite Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Master Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("master"))) {
				if (sender.hasPermission("prisontp.master")) {
					p.teleport(masterprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Master Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Guard Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("guard"))) {
				if (sender.hasPermission("prisontp.guard")) {
					p.teleport(guardprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Guard Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Riot Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("riot"))) {
				if (sender.hasPermission("prisontp.riot")) {
					p.teleport(riotprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Riot Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Officer Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("officer"))) {
				if (sender.hasPermission("prisontp.officer")) {
					p.teleport(officerprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Officer Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Captain Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("captain"))) {
				if (sender.hasPermission("prisontp.captain")) {
					p.teleport(captainprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Captain Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Staff Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("staff"))) {
				if (sender.hasPermission("prisontp.staff")) {
					p.teleport(staffprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Staff Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// Dealer Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("dealer"))) {
				if (sender.hasPermission("prisontp.dealer")) {
					p.teleport(dealerprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "Dealer Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// DrugLord Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("druglord"))) {
				if (sender.hasPermission("prisontp.druglord")) {
					p.teleport(druglordprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "DrugLord Prison");
				} else {
					p.sendMessage(ChatColor.RED + "You arn't ranked up high enough.");
				}
			}
			// SGT Prison
			if (args.length == 1 && (args[0].equalsIgnoreCase("sgt"))) {
				if (sender.hasPermission("prisontp.sgt")) {
					p.teleport(sgtprison);
					p.sendMessage(ChatColor.GREEN + "Teleported to the " + ChatColor.GRAY + "SGT Prison");
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
			p.sendMessage(ChatColor.RED + "You don't have enough permissions!");
		}
		return false;
	}
}
