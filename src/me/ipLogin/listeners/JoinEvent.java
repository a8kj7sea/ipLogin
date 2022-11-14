package me.ipLogin.listeners;

import java.util.Map.Entry;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.ipLogin.main.Main;
import me.ipLogin.methods.StoreDataMethod;
import net.md_5.bungee.api.ChatColor;

public class JoinEvent implements Listener { // Start

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!(Main.players.containsKey(p.getName()))) {
			Main.players.put(p.getName(), p.getAddress().getHostString());
			StoreDataMethod.Load();
			StoreDataMethod.Save();
		} else {
			for (Entry<String, String> t : Main.players.entrySet()) {
				String ip = t.getValue();
				if (!(p.getAddress().getHostString().equalsIgnoreCase(ip))) {
					p.kickPlayer(ChatColor.RED
							+ "There is a problem. You logged in before this time and your IP was saved for the first time. Please contact the server administration and open a ticket to solve the problem and verify you !! \n"
							+ StoreDataMethod.Link);
				}
			}
		}
	}

} // End
