package com.evenement.fr;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import com.bases.fr.Main;

public class BreakBlock implements Listener{	

	private Main plugin;
	
	
	public BreakBlock(Main main) {
		this.plugin = main;
	}
	

	@EventHandler
	public void onBreakBlock(BlockBreakEvent e){
		e.setCancelled(true);					
	}
	
	
}
