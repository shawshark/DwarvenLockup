package me.matthijs110.DwarvenLockup;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;
import net.minecraft.server.v1_7_R1.SharedConstants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public static class Global {
		public static Economy eco = null;
		public static Permission  perm = null;
		public static int updater = 0;
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			Global.eco = economyProvider.getProvider(); // This line is changed
		}
		return (Global.eco != null); //This line is changed
	}
	
	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			Global.perm= permissionProvider.getProvider();
		}
		return (Global.perm != null);
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new PrisonSignEvent(), this);
		getServer().getPluginManager().registerEvents(new ScoreBoard(this), this);
		
		setupEconomy();
		setupPermissions();
		/*getServer().getPluginManager().registerEvents(new ShopTP(), this);

		getCommand("prison").setExecutor(new PrisonTP());
		getCommand("shop").setExecutor(new ShopTP());*/
	}

	public void Link(Player player) {
		IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\"                        §eVisit our site \",\"extra\":[{\"text\":\"§bClick Here\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§7Click to visit §a§ohttp://dwarvenlockup.enjin.com\"},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://dwarvenlockup.enjin.com\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
	
	public void Rules(Player player) {
		IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\"                         §aPlease read the \",\"extra\":[{\"text\":\"§c§lRules\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§7Click to read the §cRules\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/rules\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}
	
	public void MoreRulesLink(Player player) {
		IChatBaseComponent comp = ChatSerializer
				.a("{\"text\":\"                        §6For the full rules list \",\"extra\":[{\"text\":\"§eClick Here\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§9Click to read the full rules list\"},\"clickEvent\":{\"action\":\"open_url\",\"value\":\"http://dwarvenlockup.enjin.com/rules\"}}]}");
		PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	// Join
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		@SuppressWarnings("unused")
		String player = event.getPlayer().getName();
		Player p = event.getPlayer();
		if (p.hasPlayedBefore()) {
			p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "------------" + ChatColor.DARK_RED + "Dwarven Lockup" + ChatColor.DARK_GRAY + " - " + ChatColor.DARK_RED + "Prison Server" + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "------------");
			p.sendMessage("              " + ChatColor.GRAY + "Look around the spawn for help & info!");
			p.sendMessage("                " + ChatColor.GRAY + "Visit our website for a full rules list,");
			p.sendMessage("              " + ChatColor.GRAY + "detailed donation info, guard applications");
			p.sendMessage("                          " + ChatColor.GRAY + "and a friendly forum.");
			/*p.sendMessage("                          " + ChatColor.YELLOW + "http://www.dwarvenlockup.enjin.com");*/
			Link(event.getPlayer());
			Rules(event.getPlayer());
			p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------------");

			event.setJoinMessage(ChatColor.RED + "" + p.getPlayerListName() + ChatColor.GRAY + " Joined!");

			// Wither bar text
			/*HeadsUpDisplay.displayTextBar(ChatColor.GRAY + "Welcome to " + ChatColor.DARK_RED + "Dwarven Lockup " + ChatColor.RED + player + ChatColor.GRAY + "!", event.getPlayer(), this);*/
		} else {
			Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "Welcome " + ChatColor.RED + p.getPlayerListName() + ChatColor.GRAY + "" + ChatColor.BOLD + " To" + ChatColor.DARK_RED + "" + ChatColor.BOLD + " Dwarven Lockup" + ChatColor.GRAY + "" + ChatColor.BOLD + "!");

			p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "------------" + ChatColor.DARK_RED + "Dwarven Lockup" + ChatColor.DARK_GRAY + " - " + ChatColor.DARK_RED + "Prison Server" + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "------------");
			p.sendMessage("              " + ChatColor.GRAY + "Look around the spawn for help & info!");
			p.sendMessage("                " + ChatColor.GRAY + "Visit our website for a full rules list,");
			p.sendMessage("              " + ChatColor.GRAY + "detailed donation info, guard applications");
			p.sendMessage("                          " + ChatColor.GRAY + "and a friendly forum.");
			/*p.sendMessage("                          " + ChatColor.YELLOW + "http://www.dwarvenlockup.enjin.com");*/
			Link(event.getPlayer());
			Rules(event.getPlayer());
			p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------------");
		}
	}
	// Leave
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		event.setQuitMessage(ChatColor.RED + "" + p.getPlayerListName() + ChatColor.GRAY + " Quit!");
	}
	
	public void ModifyAllowedCharacters() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = SharedConstants.class.getDeclaredField("allowedCharacters");
		field.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField( "modifiers" );
		modifiersField.setAccessible( true );
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		String oldallowedchars = (String)field.get(null);
		String suits = "\u2665\u2666\u2663\u2660\u2717";
		StringBuilder sb = new StringBuilder();
		sb.append( oldallowedchars );
		sb.append( suits );
		field.set( null, sb.toString() );
	}
	
	// X = \u2718
	// V = \u2714

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		// TEMPORARY!
		if (cmd.getName().equalsIgnoreCase("prison") || (args.length > 1) && sender.hasPermission("prisontp.*")) {
			sender.sendMessage(ChatColor.RED + "This option will be available when the prison is finished!");
		}
		if (cmd.getName().equalsIgnoreCase("shop") || (args.length > 1) && sender.hasPermission("prisontp.*")) {
			sender.sendMessage(ChatColor.RED + "This option will be available when the prison is finished!");
		}
		//\\TEMPORARY
		if (sender.hasPermission("server.rules") && (sender instanceof Player)) {
			if (cmd.getName().equalsIgnoreCase("rules")) 
				if (args.length == 1 && args[0].equalsIgnoreCase("1")) {
				sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Server Rules:");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No Hacks!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No PVP logging!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No Glitches!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No disrespect!");
				sender.sendMessage(ChatColor.DARK_GREEN + "\u2714" + ChatColor.GREEN + "  Respect higher ranks.");
				sender.sendMessage(ChatColor.DARK_GREEN + "\u2714" + ChatColor.GREEN + "  Scamming under 10K is allowed.");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  Guards are not allowed to grief other bases!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No Spamming!");
				MoreRulesLink(player);
				sender.sendMessage(ChatColor.GOLD + "For the Prison rules, do " + ChatColor.GREEN + "/rules 2");
			}
			if (args.length == 1 && args[0].equalsIgnoreCase("2")) {
				sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Prison Rules:");
				sender.sendMessage(ChatColor.GRAY + "Do NOT have ANY weapons held in your hand. If you are caught with a weapon" + ChatColor.RED + " In NO PvP Arenas:" + ChatColor.GRAY + "the guard will ask you to hand it over and count down from 5 down to 1. If you have not handed it over they can jail for 5 min ONLY, if you hand it over to them after you have been jailed you may be released at the discretion of the guard.");
				sender.sendMessage(ChatColor.GREEN + "In PvP Areas: " + ChatColor.GRAY + "The guard can kill you on sight or use the protocol above");
				sender.sendMessage(ChatColor.GRAY + "Illegal Weapons:");
				sender.sendMessage(ChatColor.GRAY + "- Any damage potions (any of them).");
				sender.sendMessage(ChatColor.GRAY + "- Bows, arrows.");
				sender.sendMessage(ChatColor.GRAY + "- Lava buckets.");
				sender.sendMessage(ChatColor.GRAY + "- Flint and Steel.");
				sender.sendMessage(ChatColor.GRAY + "- Any swords.");
				sender.sendMessage(ChatColor.GRAY + "- Eggs.");
				sender.sendMessage(ChatColor.GRAY + "- Axes (ONLY if used in PVP). You may use them in Mines.");
				sender.sendMessage(ChatColor.GRAY + "No PVP in front of guards (you can be jailed or killed by guards). Do not leave prison grounds!");
				MoreRulesLink(player);
				sender.sendMessage(ChatColor.GOLD + "For the Guard rules, Go to the site ^");
			}
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Server Rules:");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No Hacks!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No PVP logging!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No Glitches!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No disrespect!");
				sender.sendMessage(ChatColor.DARK_GREEN + "\u2714" + ChatColor.GREEN + "  Respect higher ranks.");
				sender.sendMessage(ChatColor.DARK_GREEN + "\u2714" + ChatColor.GREEN + "  Scamming under 10K is allowed.");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  Guards are not allowed to grief other bases!");
				sender.sendMessage(ChatColor.DARK_RED + "\u2718" + ChatColor.RED + "  No Spamming!");
				MoreRulesLink(player);
				sender.sendMessage(ChatColor.GOLD + "For the Prison rules, do " + ChatColor.GREEN + "/rules 2");
			}
		} else {
			sender.sendMessage("You don't have permissions!");
		}
	if (!(sender instanceof Player)) {
		sender.sendMessage(ChatColor.RED + "Sorry, you can only read the rules in-game!");
		return true;
	}
		return false;
	}
}
