package com.bases.fr;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{	//classe principale

	private EventClass ec; 				// On crée l'objet EventClass
	
	public void onEnable(){				// Fonction au démarrage du plugin
		
		ec = new EventClass(this);		// Initialise l'objet EventClass
		
		getConfig().options().copyDefaults(false);		// Créé le fichier de config (vide actuellement)
		this.saveConfig();
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(ec, this);
		System.out.println("Plugin ON");
	}
	
	
	public void onDisable(){			// Fonction à l'arret du serveur
		System.out.println("Plugin OFF");
	}	
	
	
	
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args){
		Player p = (Player) player;
		if(cmd.getName().equalsIgnoreCase("startparkour")){
			p.sendMessage("/startparkour fonctionne !");
		}
		
		
		
		return true;
	}
	
	
	
	//getItemInHand()
	

	
	
}
