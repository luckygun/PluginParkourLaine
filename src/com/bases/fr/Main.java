package com.bases.fr;

import java.io.File;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.GameModeCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{	//classe principale
	
	private EventClass ec; 				// On crée l'objet EventClass
	
	public void onEnable(){				// Fonction au démarrage du plugin
		
		ec = new EventClass(this);		// Initialise l'objet EventClass
		
		File f = new File("plugins\\PluginParkour\\config.yml");
		
		getConfig().options().copyDefaults(true);		// Créé le fichier de config 
		this.saveConfig();
		
		
		System.out.println("Plugin ON");
	}
	
	
	public void onDisable(){			// Fonction à l'arret du serveur
		System.out.println("Plugin OFF");
	}	
	
	
	
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args){
		Player p = (Player) player;
		if(cmd.getName().equalsIgnoreCase("startparkour")){
			p.sendMessage("/startparkour fonctionne !");		// Message de test
			//p.setGameMode(GameMode.ADVENTURE);				// Change le gamemode
			
			p.getInventory().setItem(0, new ItemStack(Material.STONE));
			p.getInventory().setItem(1, new ItemStack(Material.CLAY));
			p.getInventory().setItem(2, new ItemStack(Material.WOOL));
			p.updateInventory();								//update l'inventaire
			PluginManager pm = Bukkit.getServer().getPluginManager();		// "Active" la classe Event
			pm.registerEvents(ec, this);
		}
		
		
		
		return true;
	}
	
	
	
	//getItemInHand()
	

	
	
}
