package me.matthijs110.DwarvenLockup;

import me.matthijs110.DwarvenLockup.Main.Global;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard extends JavaPlugin implements Listener {

	public static Plugin plugin;
	public ScoreBoard(Main instance) {
		plugin = instance;
	}

	static Scoreboard board;
	Economy eco;
	Permission perm;
	Player player;

	// Scoreboard
	public static void scoreboard(Player player){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();

		Objective objective = board.registerNewObjective("Test", "dummy");
		objective.setDisplayName(ChatColor.RED + "Prisoner: " + ChatColor.GRAY + "" + ChatColor.ITALIC + player.getPlayerListName());
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		int OnlinePlayers = Bukkit.getOnlinePlayers().length;
		int PlayerMoney = (int) Global.eco.getBalance(player.getName());

		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Online Players"));
		score.setScore(OnlinePlayers);

		Score score2 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Money"));
		score2.setScore(PlayerMoney);
		
		Score RankupPrice = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA + "Rankup price "));
		if (player.hasPermission("prison.rankup.deputywarden")) {
			RankupPrice.setScore(0);
		}
		if (player.hasPermission("prison.rankup.c")) { //The permission node needs to be in that rank. Value contains amount of money for rankup to B. //
			RankupPrice.setScore(2000);
		}
		player.setScoreboard(board);
	}
	
	public void onCommandEvent (PlayerCommandPreprocessEvent event, String cmd, String[] args) {
		Player player = event.getPlayer();
		String message = event.getMessage().toLowerCase();
		if (message.contains("eco") == true) {
			scoreboard(player);
			player.setScoreboard(board);
		}
	}
	
	public void onCommandEvent2 (PlayerCommandPreprocessEvent event, String cmd, String[] args) {
		Player player = event.getPlayer();
		String message = event.getMessage().toLowerCase();
		if (message.contains("money") == true) {
			scoreboard(player);
			player.setScoreboard(board);
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		scoreboard(event.getPlayer());
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		scoreboard(event.getPlayer());
	}
}
