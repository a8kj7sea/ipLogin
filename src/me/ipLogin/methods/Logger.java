package me.ipLogin.methods;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class Logger { //Start

	public static String MessageColors(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	public static void Error(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(MessageColors("&c[Error] &r" + msg));
	}
	
	public static void Info(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(MessageColors("&b[Info] &r" + msg));
	}
	
	public static void Warn(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(MessageColors("&e[Warn] &r" + msg));
	}
	
	
	
} //End
