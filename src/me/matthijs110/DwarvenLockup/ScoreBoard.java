package me.matthijs110.DwarvenLockup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard implements Listener {

	private Scoreboard board;
	
	// Scoreboard
	public Scoreboard scoreboard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();

		Objective objective = board.registerNewObjective("coins", "dummy");
		objective.setDisplayName(ChatColor.RED + "Prisoner: " + ChatColor.GRAY + "" + ChatColor.ITALIC + player.getPlayerListName());
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		int OnlinePlayers = Bukkit.getOnlinePlayers().length;
		//int PlayerMoney = (int) Main.eco.getBalance(player.getName());

		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Online Players"));
		score.setScore(OnlinePlayers);

		//Score score2 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Money"));
		//score2.setScore(PlayerMoney);

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
			RankupPrice.setScore(-0);
		}
		return board;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setScoreboard(board);
	}
}