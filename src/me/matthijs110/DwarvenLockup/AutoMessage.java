package me.matthijs110.DwarvenLockup;

import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoMessage extends JavaPlugin {
	
	// Hover text events
	public void Link1(Player player) {
		IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\"§eVisit our site \",\"extra\":[{\"text\":\"§bClick Here\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§7Click to visit §a§ohttp://dwarvenlockup.enjin.com\"},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://dwarvenlockup.enjin.com\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
	
	// Auto Messages
	public void AutoMessage1() {
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage("message");
			}
		}, 0, 5 *1200);
	}
}







// Dwarven

/*public void AutoMessage1(){
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(@SuppressWarnings("unused") Player p : Bukkit.getOnlinePlayers()) {
					Bukkit.broadcastMessage("MESSAGE HERE");
				}
			}
		}, 0, 5 * 1200);
	}
}*/
