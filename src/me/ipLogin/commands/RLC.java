package me.ipLogin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ipLogin.configuration.Configuration;
import me.ipLogin.main.Main;
import me.ipLogin.methods.Logger;


public class RLC implements CommandExecutor { //Start

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) {
			Logger.Warn(Main.$ + "&cThis Command Just for Players , you can't use this command from Console !!");
			return false;
		}
		Player p = (Player) cs;
		if (p.hasPermission("ipLogin.RLC")) {
			if (args.length == 0) {
				p.sendMessage(Logger.MessageColors(Main.$ + "&aYou have been reloaded configuration successfully !"));
				Configuration.reload();
				Configuration.save();			
				Bukkit.getPluginManager().disablePlugin(Main.getMain());
				Bukkit.getPluginManager().enablePlugin(Main.getMain());
			} else {p.sendMessage(Logger.MessageColors(Main.$ + "&cWrong use , please try to type &f/rlc &cto reload configuration"));}
		} else {p.sendMessage(Logger.MessageColors(Main.$ + "&cYou don't have enough permissions to do this command"));}
		return true;
	}
	
	
} //End
