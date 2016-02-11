package com.bases.fr;

import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class EventClass implements Listener{	//Classe pour gérer les évènements

	private Main plugin;
	private PlayerLoginEvent log;

	public EventClass(Main main) {
		this.plugin = main;
	}
	

	@EventHandler
	public void onBreakBlock(BlockBreakEvent e){
		e.setCancelled(true);
	}

}
