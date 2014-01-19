package me.matthijs110.DwarvenLockup;

import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class GuardTP implements CommandExecutor {
	
	public void Link(Player player) {
		IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\"§cPurchase a Guard rank \",\"extra\":[{\"text\":\"§6Here \",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§7Click to buy a §6Guard §7rank\"},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://dwarvenlockup.enjin.com/shop#guard-ranks-311928\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		Location CGuardLounge = new Location (Bukkit.getServer().getWorld("Prison"), -148.62477129922044, 56.0 ,-88.23459439940699, 358, 0);

		if (sender.hasPermission("guard.loungetp") && cmd.getName().equalsIgnoreCase("guard")) {
			if (args.length == 0 || (args.length > 1)) {
				player.sendMessage(ChatColor.YELLOW + "Usage: /guard " + ChatColor.GRAY + "<Prison>");
				return true;
			}
			if (args[0].equals("C") || (args[0].equals("c")) && (sender.hasPermission("guard.loungetp.c"))) {
				player.teleport(CGuardLounge);
				player.sendMessage(ChatColor.YELLOW + "Teleported to the " + ChatColor.GRAY + "C " + ChatColor.YELLOW + "Guard Lounge");
			}
		}
		if (!(sender.hasPermission("guard.loungetp"))) {
			Link(player);
		}
		return false;
	}
}