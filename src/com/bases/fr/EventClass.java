package com.bases.fr;

import java.util.Set;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

public class EventClass implements Listener{	//Classe pour gérer les évènements

	private Main plugin;
	private PlayerLoginEvent log;
	private ItemStack itemInHand;
	
	public EventClass(Main main) {
		this.plugin = main;
	}
	

	@EventHandler
	public void onBreakBlock(BlockBreakEvent e){
		e.setCancelled(true);
	}
	
	@EventHandler
	public void playerItemHold(PlayerItemHeldEvent e){
		
		itemInHand = e.getPlayer().getItemInHand();
		// stone = new ItemStack(Material.STONE);
		Player p = e.getPlayer();
		
		
		if(itemInHand.getType()==Material.STONE){
			p.sendMessage("Bonjour");
			
		}
		itemInHand = e.getPlayer().getItemInHand();
		System.out.println((itemInHand.getType()));
	}
}
