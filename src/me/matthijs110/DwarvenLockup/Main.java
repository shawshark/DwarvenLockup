package me.matthijs110.DwarvenLockup;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new ShopTP(), this);
		
		getCommand("prison").setExecutor(new PrisonTP());
	}

	// Join
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		@SuppressWarnings("unused")
		String player = event.getPlayer().getName();
		Player p = event.getPlayer();
		event.setJoinMessage(ChatColor.RED + "" + p.getPlayerListName() + ChatColor.GRAY + " Joined!");

		// Wither bar text
		/*HeadsUpDisplay.displayTextBar(ChatColor.GRAY + "Welcome to " + ChatColor.DARK_RED + "Dwarven Lockup " + ChatColor.RED + player + ChatColor.GRAY + "!", event.getPlayer(), this);*/
	}
	// Leave
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		event.setQuitMessage(ChatColor.RED + "" + p.getPlayerListName() + ChatColor.GRAY + " Quit!");
	}
}
