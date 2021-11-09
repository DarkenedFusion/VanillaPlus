package com.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_16_R3.WorldServer;

public class SpawnEntity implements Listener {
	
	/*@EventHandler
	public void onSpawn(EntitySpawnEvent event) {
		if (!(event.getEntity() instanceof Animals))
			return;
		if (event.getLocation().getBlock().isLiquid())
			return;
		if ((int) (Math.random() * 10) == 1) { // 0 - 9 10% chance
			event.setCancelled(true);
			
			TurkeyAlpha pack = new TurkeyAlpha(event.getLocation());
			
			WorldServer world = ((CraftWorld)event.getLocation().getWorld()).getHandle();
			world.addEntity(pack);
			
		}
	}
	*/
	@EventHandler
	public void onTurkeyDie(EntityDeathEvent event) {
		if(event.getEntity() instanceof Chicken) {
			Chicken chicken = (Chicken) event.getEntity();
			if(chicken.getCustomName().contains("Alpha Chicken")){
				double random = Math.random();
				if(random >= 0.25D) {
				ItemStack turkey = new ItemStack(Material.CHICKEN);
				ItemMeta meta = turkey.getItemMeta();
				meta.setDisplayName(ChatColor.WHITE + "Raw Turkey");
				turkey.setItemMeta(meta);
				chicken.getWorld().dropItem(chicken.getLocation(), turkey);
				
				
				
				
				} else {
					return;
				}
				
				if ((int) (Math.random() * 10) == 1) {
					ItemStack turkeyHide = new ItemStack(Material.RABBIT_HIDE);
					ItemMeta meta2 = turkeyHide.getItemMeta();
					meta2.setDisplayName(ChatColor.WHITE + "Turkey Hide");
					turkeyHide.setItemMeta(meta2);
					chicken.getWorld().dropItem(chicken.getLocation(), turkeyHide);
				}
				
			}
		}
	}
	
	
	@EventHandler
	public void onTBow(PlayerInteractEvent  event) {
			Player player = event.getPlayer();
			Action action = event.getAction();
			
			ItemStack turkeyBow = new ItemStack(Material.BOW);
			ItemMeta meta = turkeyBow.getItemMeta();
			meta.setDisplayName(ChatColor.YELLOW + "Turkey Bow");
			meta.addEnchant(Enchantment.ARROW_DAMAGE, 2, false);
			turkeyBow.setItemMeta(meta);
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Turkey Bow")) {
				
				Location location = player.getLocation();
     			
     			for (int degree = 0; degree < 360; degree++) {
     			    double radians = Math.toRadians(degree);
     			    double x = Math.cos(radians);
     			    double z = Math.sin(radians);
     			    location.add(x,0,z);
     			    player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location, 1);
     			    location.subtract(x,0,z);
     			}
				
				
			}
				
				
				
			}
		}
	}

	


