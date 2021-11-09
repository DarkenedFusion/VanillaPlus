package com.darkenedfusion;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.md_5.bungee.api.ChatColor;

public class customEnchants implements Listener {
	
	
	//Thor I
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		Entity damager = event.getDamager();
		if(damager instanceof Player) {
			Player player = (Player) event.getDamager();
			 List<String> lore = player.getInventory().getItemInMainHand().getItemMeta().getLore();	
			 if(lore.contains(ChatColor.GRAY + "Thor I")) {
				 double doubleRandom = Math.random();
				 if(doubleRandom <= 0.25D) {
					 LivingEntity victim = (LivingEntity) event.getEntity();
					 victim.getWorld().strikeLightning(victim.getLocation());
				 }
			 }
					
				}
			
		}
	}
	


