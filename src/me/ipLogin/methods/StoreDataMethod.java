package me.ipLogin.methods;

import java.util.Map.Entry;

import me.ipLogin.configuration.Configuration;
import me.ipLogin.main.Main;
import net.md_5.bungee.api.ChatColor;

public class StoreDataMethod { // Start

	public static String Link = ChatColor.translateAlternateColorCodes('&',
			Configuration.getConfig().getString("Kick-Message.Link"));

	public static void Save() {
		for (Entry<String, String> entry : Main.players.entrySet()) {
			Configuration.getConfig().set("ipLogin.List." + entry.getKey(), entry.getValue());
		}

		Configuration.save();
	}

	public static void Load() {
		if (Configuration.getConfig().getConfigurationSection("ipLogin.List") != null) {
			for (String key : Configuration.getConfig().getConfigurationSection("ipLogin.List").getKeys(false)) {
				Main.players.put(key, Configuration.getConfig().getString("ipLogin.List." + key));
			}
		}
	}

} // End
