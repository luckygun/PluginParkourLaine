package com.bases.fr;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.evenement.fr.*;

public class Main extends JavaPlugin{	//classe principale
	
	private BreakBlock bb; 				// On crée l'objet qui gere l'évènement lorsque l'on casse un block
	private EvenementLaine event;		// On crée l'objet qui gere l'évènement lorsque l'on a un block en main
	
	
	public void onEnable(){				// Fonction au démarrage du plugin
		bb = new BreakBlock(this);		// Initialise l'objet BreakBlock
		event = new EvenementLaine(this);	// Initialise l'objet EvenementLaine
		
		getConfig().options().copyDefaults(false);		// Créé le fichier de config 
		this.saveConfig();
		System.out.println("Plugin ON");				//affiche un message dans la console du serveur
	}
	
	
	public void onDisable(){							// Fonction à l'arret du serveur
		System.out.println("Plugin OFF");				//affiche un message dans la console du serveur
	}	
	
	
	
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args){
		Player p = (Player) player;
		if(cmd.getName().equalsIgnoreCase("startparkour")){
			p.sendMessage("/startparkour fonctionne !");		// Message de test
			//p.setGameMode(GameMode.ADVENTURE);				// Change le gamemode
			
			p.getInventory().setItem(0, new ItemStack(Material.STONE));		//Remplis l'inventaire
			p.getInventory().setItem(1, new ItemStack(Material.CLAY));
			p.getInventory().setItem(2, new ItemStack(Material.WOOL));
			p.updateInventory();								//update l'inventaire
			
			PluginManager pm0 = Bukkit.getServer().getPluginManager();		// "Active" l'objet qui gere l'évènement lorsque l'on a un block en main
			pm0.registerEvents(event, this);
			
			PluginManager pm1 = Bukkit.getServer().getPluginManager();		// "Active" l'objet qui gere l'évènement lorsque l'on casse un block
			pm1.registerEvents(bb, this);
		}
		
		
		return true;
	}
}
