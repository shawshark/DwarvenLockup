package me.matthijs110.DwarvenLockup;

import me.matthijs110.DwarvenLockup.Main.Global;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard implements Listener {

	static Scoreboard board;
	Economy eco;
	Permission perm;
	Player player;

	// Scoreboard
	public static void scoreboard(Player player){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();

		Objective objective = board.registerNewObjective("coins", "dummy");
		objective.setDisplayName(ChatColor.RED + "Prisoner: " + ChatColor.GRAY + "" + ChatColor.ITALIC + player.getPlayerListName());
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		int OnlinePlayers = Bukkit.getOnlinePlayers().length;
		int PlayerMoney = (int) Global.eco.getBalance(player.getName());

		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Online Players"));
		score.setScore(OnlinePlayers);

		Score score2 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Money"));
		score2.setScore(PlayerMoney);
		
		Score RankupPrice = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA + "Rankup price "));
		if (player.hasPermission("prison.rankup.c")) { //The permission node needs to be in that rank. Value contains amount of money for rankup to B. //
			RankupPrice.setScore(25000);
		}
		if (player.hasPermission("prison.rankup.b")) {
			RankupPrice.setScore(50000);
		}
		if (player.hasPermission("prison.rankup.a")) {
			RankupPrice.setScore(100000);
		}
		if (player.hasPermission("prison.rankup.elite")) {
			RankupPrice.setScore(225000);
		}
		if (player.hasPermission("prison.rankup.master")) {
			RankupPrice.setScore(500000);
		}
		if (player.hasPermission("prison.rankup.guard")) {
			RankupPrice.setScore(1500000);
		}
		if (player.hasPermission("prison.rankup.done")) {
			RankupPrice.setScore(0);
		}
		player.setScoreboard(board);
	}
	
	/*@EventHandler
	public void onCommandEvent (PlayerCommandPreprocessEvent event, String cmd, String[] args) {
		Player player = event.getPlayer();
		String message = event.getMessage().toLowerCase();
		if (message.contains("eco")) {
			scoreboard(player);
		}
	}
	
	@EventHandler
	public void onCommandEvent2 (PlayerCommandPreprocessEvent event, String cmd, String[] args) {
		Player player = event.getPlayer();
		String message = event.getMessage().toLowerCase();
		if (message.contains("money")) {
			scoreboard(player);
		}
	}*/
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		SBRefresh();
	}
	
	public void SBRefresh() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin) this, new Runnable(){
			public void run(){
				for(Player p : Bukkit.getOnlinePlayers()){
					scoreboard(p);
				}
			}
		}, 0, 5 * 1200);
	}
}
