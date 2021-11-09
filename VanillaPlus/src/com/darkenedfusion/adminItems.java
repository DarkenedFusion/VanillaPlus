package com.darkenedfusion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class adminItems implements Listener {
	
	private static final String RLAUNCHER = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM0ZWIzNTZiNTc1MjEyYTkyMWFiNzg2MTY4MzIxZmVhNDc2ZTRiYmQzYzFiNmE2N2Y1YTRiYTA5MTM1M2EifX19";
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		ItemStack rLauncher = SkullCreator.itemWithBase64(SkullCreator.createSkull(), RLAUNCHER);
		ItemMeta meta = rLauncher.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Rocket Launcher");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Item Ability:");
		lore.add(ChatColor.GRAY + "Right Click: Shoots a rocket!");
		lore.add(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Admin Item.");
		meta.setLore(lore);
		rLauncher.setItemMeta(meta);
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(event.getHand() != EquipmentSlot.HAND)  return;
		if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Rocket Launcher")) {
			player.sendMessage("work2");
		if(a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
			player.sendMessage("work3");
				Horse horse = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
				horse.setInvisible(true);
				horse.addPassenger(player);
				
				new BukkitRunnable() {
					double t = 0;
					public void run() {
						t += 1;
						
						
						horse.setVelocity(player.getLocation().getDirection().multiply(2));
						if(t == 86) {
							horse.removePassenger(player);
							horse.setVelocity(horse.getLocation().getDirection().multiply(0));
							player.sendMessage("Going Down!");
						}
						
						if(t == 95) {
							horse.setHealth(0);
							horse.getWorld().createExplosion(horse.getLocation(), 3);
						}
						
						if(t > 100) {
							this.cancel();
						}
						
						
					}
					
				}.runTaskTimer(Main.getInstance(), 0, 1);
				
			}
		}
		}
	
	
	
	

}
