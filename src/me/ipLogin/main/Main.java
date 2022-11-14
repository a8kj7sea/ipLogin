package me.ipLogin.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.ipLogin.commands.RLC;
import me.ipLogin.configuration.Configuration;
import me.ipLogin.listeners.JoinEvent;
import me.ipLogin.listeners.MoveEvent;
import me.ipLogin.methods.Logger;
import me.ipLogin.methods.StoreDataMethod;

public class Main extends JavaPlugin { // Start

	public Configuration c;
	public static HashMap<String, String> players;
	public static Main main;
	public static String $ = "&8︳ &6ipLogin &8︳ ";
	
	@Override
	public void onEnable() {
		main = this;
		c = new Configuration("config.yml", this, true);
		players = new HashMap<String, String>();
		StoreDataMethod.Load();
		StoreDataMethod.Save();
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
		getCommand("rlc").setExecutor(new RLC());
		Bukkit.getConsoleSender().sendMessage(Logger.MessageColors("&6ipLogin &ahas been enabled"));
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Logger.MessageColors("&6ipLogin &chas been Disabled"));
	}
	
	public static Main getMain() {
		return main;
	}

} // End
