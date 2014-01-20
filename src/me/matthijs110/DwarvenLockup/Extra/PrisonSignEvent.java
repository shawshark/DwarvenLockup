package me.matthijs110.DwarvenLockup.Extra;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PrisonSignEvent implements Listener {

	// Colored Text on Signs
	@EventHandler
	public void onSign(SignChangeEvent e) {
		e.setLine(0, ChatColor.translateAlternateColorCodes('&', e.getLine(0)));
		e.setLine(1, ChatColor.translateAlternateColorCodes('&', e.getLine(1)));
		e.setLine(2, ChatColor.translateAlternateColorCodes('&', e.getLine(2)));
		e.setLine(3, ChatColor.translateAlternateColorCodes('&', e.getLine(3)));
	}

	// Elite Prison Sign
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		if (event.getPlayer().hasPermission("prison.sign.make")) {
			if (event.getLine(2).equals(ChatColor.BOLD + "C")) {
				event.setLine(0, ChatColor.GRAY + "===============");
				event.setLine(1, ChatColor.BLUE + "" + ChatColor.BOLD + "C-Prison");
				event.setLine(2, ChatColor.DARK_BLUE + "Stand here");
				event.setLine(3, ChatColor.GRAY + "===============");
			}
			if (event.getLine(2).equals(ChatColor.BOLD + "B")) {
				event.setLine(0, ChatColor.GRAY + "===============");
				event.setLine(1, ChatColor.GREEN + "" + ChatColor.BOLD + "B-Prison");
				event.setLine(2, ChatColor.DARK_BLUE + "Stand here");
				event.setLine(3, ChatColor.GRAY + "===============");
			}
			if (event.getLine(2).equals(ChatColor.BOLD + "A")) {
				event.setLine(0, ChatColor.GRAY + "===============");
				event.setLine(1, ChatColor.AQUA + "" + ChatColor.BOLD + "A-Prison");
				event.setLine(2, ChatColor.DARK_BLUE + "Stand here");
				event.setLine(3, ChatColor.GRAY + "===============");
			}
			if (event.getLine(2).equals(ChatColor.BOLD + "Elite")) {
				event.setLine(0, ChatColor.GRAY + "===============");
				event.setLine(1, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "ElitePrison");
				event.setLine(2, ChatColor.DARK_BLUE + "Stand here");
				event.setLine(3, ChatColor.GRAY + "===============");
			}
			if (event.getLine(2).equals(ChatColor.BOLD + "Master")) {
				event.setLine(0, ChatColor.GRAY + "===============");
				event.setLine(1, ChatColor.RED + "" + ChatColor.BOLD + "MastrPrison");
				event.setLine(2, ChatColor.DARK_BLUE + "Stand here");
				event.setLine(3, ChatColor.GRAY + "===============");
			}
			if (event.getLine(2).equals(ChatColor.BOLD + "Rules")) {
				event.setLine(0, ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click me]");
				event.setLine(1, ChatColor.BLUE + "To read the");
				event.setLine(2, ChatColor.BLUE + "Rules");
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
        Block b = event.getClickedBlock();
        Action action = event.getAction();
        
        if (event.getClickedBlock() == null) {
        	return;
        }
        if (action == Action.RIGHT_CLICK_BLOCK && b !=null && (b.getType() == Material.SIGN_POST || b.getType() == Material.WALL_SIGN)) {
        	Sign sign = (Sign) b.getState();
        	
        	if (sign.getLine(0).equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[Click me]") && sign.getLine(1).equals(ChatColor.BLUE + "To read the") && sign.getLine(2).equals(ChatColor.BLUE + "Rules")) {
        		player.chat("/rules");
        	}
        }
	}
}
