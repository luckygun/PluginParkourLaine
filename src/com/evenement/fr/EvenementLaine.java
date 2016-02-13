package com.evenement.fr;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import com.bases.fr.Main;

public class EvenementLaine implements Listener{

	private Main plugin;
	
	public EvenementLaine(Main main) {		//constructeur
		this.plugin = main;
	}
	
	
	@EventHandler
	public boolean playerItemHold(PlayerItemHeldEvent e){
		Player p = e.getPlayer();												// Take le joueur
		ItemStack itemInHand = p.getInventory().getItem(e.getNewSlot());		// Take item in Hand
				
		
		if(itemInHand.getType()==Material.STONE){
			p.sendMessage("stone");											// Case if item is stone
		}else if(itemInHand.getType()==Material.CLAY){
			p.sendMessage("clay");											// Case if item is clay	
		}else if(itemInHand.getType()==Material.WOOL){
			p.sendMessage("wool");											// Case if item is wool
		}else{
			return false;
		}
		
		return true;
	}
	
	
	
}
