package me.ipLogin.configuration;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

	private static File file;
	private static FileConfiguration config;

	public Configuration(String fileName, JavaPlugin plugin, boolean saveDefault) {
		file = new File(plugin.getDataFolder(), fileName);
		file.getParentFile().mkdirs();
		if (!file.exists()) {
			if (saveDefault) {
				plugin.saveResource(fileName, true);
			} else {
				try {
					file.createNewFile();
				} catch (IOException var5) {
					var5.printStackTrace();
				}
			}
		}

		config = YamlConfiguration.loadConfiguration(file);
	}

	public static void save() {
		try {
			config.save(file);
		} catch (IOException var1) {
			var1.printStackTrace();
		}

	}

	public static void reload() {
		config = YamlConfiguration.loadConfiguration(file);
	}

	public static FileConfiguration getConfig() {
		return config;
	}
}