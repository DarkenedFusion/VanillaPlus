package com.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.darkenedfusion.CooldownManager.CustomEffects;

public class customItems implements Listener {
	private static final String PWOOD = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjBjZDEzMjIzYThkOWMxNzNjZWRjZTZjNGJlYmViYTA2YTI0YTFiYTI3NWRkM2ViNWM3OTMzZjlhNzRiYTAxMSJ9fX0=";
	
	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void lifeFruit(PlayerItemConsumeEvent event) {
		ItemStack lFruit = new ItemStack(Material.APPLE);
		ItemMeta meta = lFruit.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Life Fruit");
		lFruit.setItemMeta(meta);
		Player player = event.getPlayer();
		if(event.getItem().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Life Fruit")) {
			if(player.getMaxHealth() >= 40) {
				player.sendMessage(ChatColor.GRAY + "You can not eat any more!");
				event.setCancelled(true);
				return;
				
			}
			player.setMaxHealth(player.getMaxHealth() + 2);
			player.setHealth(player.getMaxHealth());
			player.sendMessage(ChatColor.GRAY + "You have just gained " + ChatColor.RED + "❤2");
		}
		}
			
			
		
	
	
	@EventHandler
	public void rawTurkey(PlayerItemConsumeEvent event) {
		ItemStack rTurkey = new ItemStack(Material.CHICKEN);
		ItemMeta meta = rTurkey.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Life Fruit");
		rTurkey.setItemMeta(meta);
		Player player = event.getPlayer();
		if(event.getItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Raw Turkey")) {
			player.setFoodLevel(player.getFoodLevel() + 8);
			player.getInventory().remove(rTurkey);
			
		}
		
	}

	
	@EventHandler
	public void onCrystalAxeBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.LIGHT_PURPLE + "Crystal Axe")) {
			if(event.getBlock().getType() == Material.OAK_LOG) {
			Block log = event.getBlock();
			double randDouble = Math.random();
			if(randDouble <= 0.05D) {
				ItemStack wLog = new ItemStack(Material.OAK_LOG);
				
				event.getBlock().getWorld().dropItemNaturally(log.getLocation(), wLog);
				player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.LIGHT_PURPLE + "gained" + ChatColor.GRAY + " an extra log!");
				player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
			}
			if(randDouble <= 0.01D) {
				ItemStack pWood = SkullCreator.itemWithBase64(SkullCreator.createSkull(), PWOOD);
				ItemMeta meta = pWood.getItemMeta();
				meta.setDisplayName(ChatColor.YELLOW + "Petrified Log");
				pWood.setItemMeta(meta);
				
				event.getBlock().getWorld().dropItemNaturally(log.getLocation(), pWood);
				
			}
			}
			if(event.getBlock().getType() == Material.BIRCH_LOG) {
				Block log = event.getBlock();
				double randDouble = Math.random();
				if(randDouble <= 0.05D) {
					ItemStack wLog = new ItemStack(Material.BIRCH_LOG);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), wLog);
					player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.LIGHT_PURPLE + "gained" + ChatColor.GRAY + " an extra log!");
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
				}
				if(randDouble <= 0.01D) {
					ItemStack pWood = SkullCreator.itemWithBase64(SkullCreator.createSkull(), PWOOD);
					ItemMeta meta = pWood.getItemMeta();
					meta.setDisplayName(ChatColor.YELLOW + "Petrified Log");
					pWood.setItemMeta(meta);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), pWood);
					
				}
				}
			
			if(event.getBlock().getType() == Material.ACACIA_LOG) {
				Block log = event.getBlock();
				double randDouble = Math.random();
				if(randDouble <= 0.05D) {
					ItemStack wLog = new ItemStack(Material.ACACIA_LOG);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), wLog);
					player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.LIGHT_PURPLE + "gained" + ChatColor.GRAY + " an extra log!");
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
				}
				if(randDouble <= 0.01D) {
					ItemStack pWood = SkullCreator.itemWithBase64(SkullCreator.createSkull(), PWOOD);
					ItemMeta meta = pWood.getItemMeta();
					meta.setDisplayName(ChatColor.YELLOW + "Petrified Log");
					pWood.setItemMeta(meta);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), pWood);
					
				}
				}
			
			if(event.getBlock().getType() == Material.DARK_OAK_LOG) {
				Block log = event.getBlock();
				double randDouble = Math.random();
				if(randDouble <= 0.05D) {
					ItemStack wLog = new ItemStack(Material.DARK_OAK_LOG);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), wLog);
					player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.LIGHT_PURPLE + "gained" + ChatColor.GRAY + " an extra log!");
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
				}
				if(randDouble <= 0.01D) {
					ItemStack pWood = SkullCreator.itemWithBase64(SkullCreator.createSkull(), PWOOD);
					ItemMeta meta = pWood.getItemMeta();
					meta.setDisplayName(ChatColor.YELLOW + "Petrified Log");
					pWood.setItemMeta(meta);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), pWood);
					
				}
				}
			
			if(event.getBlock().getType() == Material.JUNGLE_LOG) {
				Block log = event.getBlock();
				double randDouble = Math.random();
				if(randDouble <= 0.05D) {
					ItemStack wLog = new ItemStack(Material.JUNGLE_LOG);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), wLog);
					player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.LIGHT_PURPLE + "gained" + ChatColor.GRAY + " an extra log!");
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
				}
				if(randDouble <= 0.01D) {
					ItemStack pWood = SkullCreator.itemWithBase64(SkullCreator.createSkull(), PWOOD);
					ItemMeta meta = pWood.getItemMeta();
					meta.setDisplayName(ChatColor.YELLOW + "Petrified Log");
					pWood.setItemMeta(meta);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), pWood);
					
				}
				}
			
			if(event.getBlock().getType() == Material.SPRUCE_LOG) {
				Block log = event.getBlock();
				double randDouble = Math.random();
				if(randDouble <= 0.05D) {
					ItemStack wLog = new ItemStack(Material.SPRUCE_LOG);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), wLog);
					player.sendMessage(ChatColor.GRAY + "You have " + ChatColor.LIGHT_PURPLE + "gained" + ChatColor.GRAY + " an extra log!");
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
				}
				if(randDouble <= 0.01D) {
					ItemStack pWood = SkullCreator.itemWithBase64(SkullCreator.createSkull(), PWOOD);
					ItemMeta meta = pWood.getItemMeta();
					meta.setDisplayName(ChatColor.YELLOW + "Petrified Log");
					pWood.setItemMeta(meta);
					
					event.getBlock().getWorld().dropItemNaturally(log.getLocation(), pWood);
					
				}
				}
		  
		
		}
		
	}
	
	
	
	  @EventHandler
	  public void onPrismarineSet(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
						if(player.getEquipment().getHelmet().getItemMeta().getDisplayName().contains("Prismarine Helmet")) {
							if(player.getEquipment().getChestplate().getItemMeta().getDisplayName().contains("Prismarine Chestplate")) {
								if(player.getEquipment().getLeggings().getItemMeta().getDisplayName().contains("Prismarine Leggings")) {
									if(player.getEquipment().getBoots().getItemMeta().getDisplayName().contains("Prismarine Boots")) {
										if(player.isSneaking()) {
											if(!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.PRISMARINE)) {
											player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 20*10, 0));
											
											CooldownManager.setCooldown(player.getUniqueId(), CooldownManager.CustomEffects.PRISMARINE, 12);
										}
										}
									}
								}
							}
						}
				} 
		
			
	
	
	@EventHandler
	public void magicWand(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Eye of the Storm")) {
			if(a.equals(Action.RIGHT_CLICK_BLOCK) || a.equals(Action.RIGHT_CLICK_AIR)) {
				
				new BukkitRunnable(){	
					Player player = event.getPlayer();
					Location loc = player.getLocation();
					double t = Math.PI/4;
					public void run() {
					t = t + 0.1*Math.PI;
					for (double theta = 0; theta <= 2*Math.PI; theta = theta + Math.PI/32){
						double x = t*Math.cos(theta);
						double y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
						double z = t*Math.sin(theta);
						loc.add(x,y,z);
						player.spawnParticle(Particle.FLAME,loc,0,0,0,0,1);
						loc.subtract(x,y,z);
	 
						theta = theta + Math.PI/64;
	 
						x = t*Math.cos(theta);
						y = 2*Math.exp(-0.1*t) * Math.sin(t) + 1.5;
						z = t*Math.sin(theta);
						loc.add(x,y,z);
						player.spawnParticle(Particle.SOUL_FIRE_FLAME,loc,0,0,0,0,1);
						loc.subtract(x,y,z);
						
						
					}
					if (t > 20){
						this.cancel();
					}
						
					}
				}.runTaskTimer(Main.getInstance(), 0, 1);
				
				
				
				
				
			}
		
		}
	}
	
	@EventHandler
	public void onShoot(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) event.getEntity();
			if(event.getDamager() instanceof Arrow) {
				Arrow arrow = (Arrow) event.getDamager();
				if(arrow.getShooter() instanceof Player) {
					Player player = (Player) arrow.getShooter();
					if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(ChatColor.BLUE + "Eye of the Storm")) {
					double randChance = Math.random();
					if(randChance <= 0.15D) {
						entity.getWorld().strikeLightning(entity.getLocation());
					}
					
					if(player.getWorld().hasStorm() == true) {
						if(randChance <= 0.35D) {
							entity.getWorld().strikeLightning(entity.getLocation());
						}
					}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onWindClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		  ItemStack windSword = new ItemStack(Material.IRON_SWORD);
		  Damageable metaDamage = (Damageable) windSword.getItemMeta();
		if(event.getHand() != EquipmentSlot.HAND) return;
		if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Wind Blade")) {
			if(a.equals(Action.RIGHT_CLICK_BLOCK) || a.equals(Action.RIGHT_CLICK_AIR)) {
				  if(!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.WIND)) {
					  metaDamage.setDamage(metaDamage.getDamage() - 10);
					  
					  
					  
					  
					  
				new BukkitRunnable(){	
					Vector dir = player.getLocation().getDirection().normalize();
					Location loc = player.getLocation();
					double t = 0;
	 
					public void run(){
						t += 0.5;
						double x = dir.getX() * t;
						double y = dir.getY() * t + 1.5;
						double z = dir.getZ() * t;
						loc.add(x,y,z);
						player.getWorld().spawnParticle(Particle.CLOUD, loc, 0, 0, 0, 0, 5);
						loc.subtract(x, y, z);
						
						
					
					}
				}.runTaskTimer(Main.getInstance(), 0, 1);
				
				LivingEntity entity = (LivingEntity) event.getPlayer();
				Location loc = entity.getLocation();
				
				
				
				
				 if(player.getLocation().distance(loc) < 10.0){
					 entity.setVelocity(entity.getVelocity().setY(0));
					 entity.setVelocity(entity.getLocation().getDirection().multiply(-3.1D));
					 entity.setVelocity(entity.getVelocity().setY(1.12D));
					 windSword.setItemMeta((ItemMeta) metaDamage);
					 
					  CooldownManager.setCooldown(player.getUniqueId(), CooldownManager.CustomEffects.WIND, 3);
				}
					
			}
					
				
		}
		}
	
	
	}

	

	
	@EventHandler
	public void onIceBlade(EntityDamageByEntityEvent event) {
		Entity damager = event.getDamager();
		if(damager instanceof Player) {
			Player player = (Player) event.getDamager();
			if(player.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD)) {
				if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals
						(ChatColor.AQUA + "Ice Blade"));
					double randDouble = Math.random();
					if(randDouble <= 0.15D) {
						LivingEntity victim = (LivingEntity) event.getEntity();
						victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
					}
					
				}
			}
		
	}

	

@EventHandler
	public void onFlameClick(PlayerInteractEvent event) {
	Player player = event.getPlayer();
	Action a = event.getAction();
	if(event.getHand() != EquipmentSlot.HAND) return;
	if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Fire Blade")) {
		if(a.equals(Action.RIGHT_CLICK_BLOCK) || a.equals(Action.RIGHT_CLICK_AIR)) {
			  if(!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.FIRE)) {
				  
				  
				  
				  
				  
				  new BukkitRunnable(){
		                Location loc = player.getEyeLocation();
		                Vector vec = loc.getDirection().normalize();
		                int amount = 40;
		                float radius = 1f;
		                int count = 0;
		                public void run() {
		                    count++;
		                    loc.add(vec);
		                    for (int i = 0; i < amount; i++) {
		                        double angle, x, y, z;
		                        angle = 2 * Math.PI * i / amount;
		                        x = Math.sin(angle) * radius;
		                        z = Math.sin(angle) * radius;
		                        y = Math.cos(angle) * radius;
		                        loc.add(x, z, y);
		                        player.getWorld().spawnParticle(Particle.FLAME, loc ,0, 0, 255, 1, 0);
		                        loc.subtract(x, z, y);
		                    }
		                    if (count>30){
		                        this.cancel();
		                    }
		                }
			}.runTaskTimer(Main.getInstance(), 0, 1);
			Fireball fireball = player.launchProjectile(Fireball.class);
			
			 CooldownManager.setCooldown(player.getUniqueId(), CustomEffects.FIRE, 3);
			  }
		}
	}
}


	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEarthBlade(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action a = event.getAction();
		if(event.getHand() != EquipmentSlot.HAND) return;
		if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Earth Blade")) {
			if(a.equals(Action.RIGHT_CLICK_BLOCK) || a.equals(Action.RIGHT_CLICK_AIR)) {
				  if(!CooldownManager.hasCooldown(player.getUniqueId(), CooldownManager.CustomEffects.EARTH)) {
					  
					  Location dir = player.getEyeLocation().clone();
					  FallingBlock block = player.getWorld().spawnFallingBlock(player.getLocation().add(new Vector(0, 3, 0)), Material.STONE, (byte) 0);
					  
					  Vector v = block.getVelocity();
					  block.setVelocity(player.getLocation().getDirection().multiply(2));
					  
					  
					  new BukkitRunnable() {
						  
						  public void run() {
							  if(block.isOnGround()) {
								  block.getWorld().createExplosion(block.getLocation(), 3);
							  }
						  }
						  
						  
					  }.runTaskLater(Main.getInstance(), 20);
					 
					  CooldownManager.setCooldown(player.getUniqueId(), CooldownManager.CustomEffects.EARTH, 3);
				}
					
			}
					
				
		
		
	
	
	
	}
}

}


	




			  
	
	


