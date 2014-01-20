package me.matthijs110.DwarvenLockup.Extra;

import me.matthijs110.DwarvenLockup.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreBoard {

	public Main m;

	public ScoreBoard(Main m) {
		this.m = m;
	}

	public void updatescoreboard (Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard sb = manager.getNewScoreboard();
		Objective objective = sb.registerNewObjective("coins", "dummy");
		objective.setDisplayName(ChatColor.RED + "Prisoner: " + ChatColor.GRAY + "" + ChatColor.ITALIC + p.getPlayerListName());
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		Score online = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Online Players"));
		Score money = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "Money"));
		Score RankupPrice = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA + "Rankup price "));

		online.setScore(Bukkit.getServer().getOnlinePlayers().length);
		money.setScore((int) m.eco.getBalance(p.getName()));
		if (p.hasPermission("prison.rankup.c")) { //The permission node needs to be in that rank. Value contains amount of money for rankup to B. //
			RankupPrice.setScore(25000);
		}
		if (p.hasPermission("prison.rankup.b")) {
			RankupPrice.setScore(50000);
		}
		if (p.hasPermission("prison.rankup.a")) {
			RankupPrice.setScore(100000);
		}
		if (p.hasPermission("prison.rankup.elite")) {
			RankupPrice.setScore(225000);
		}
		if (p.hasPermission("prison.rankup.master")) {
			RankupPrice.setScore(500000);
		}
		if (p.hasPermission("prison.rankup.guard")) {
			RankupPrice.setScore(1500000);
		}
		if (p.hasPermission("prison.rankup.done")) {
			RankupPrice.setScore(-0);
		}

		p.setScoreboard(sb);
	}

	public void updateforeveryone() {
		for(Player online : m.getServer().getOnlinePlayers()) {
			updatescoreboard(online);
		}
	}
}