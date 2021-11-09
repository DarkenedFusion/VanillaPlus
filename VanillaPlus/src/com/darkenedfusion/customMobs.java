package com.darkenedfusion;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public class customMobs implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBossSpawn(EntitySpawnEvent event) {
		if(event.getEntity() instanceof Giant) {
			Giant giant = (Giant) event.getEntity();
			if(giant.getCustomName().contains("Fire Boss")) {
			giant.setMaxHealth(1000.0);
			giant.setHealth(1000.0);
			}
		} else return;
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			if(zombie.getCustomName().contains("Wind Boss")) {
				zombie.setMaxHealth(1500.0);
				zombie.setHealth(1500.0);
			}
		} else return;
		
		}
	
	
	@EventHandler
	public void onBossDamage(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Giant) {
			Giant giant = (Giant) event.getEntity();
			if(giant.getCustomName().contains("Fire Boss")) {
			if(event.getDamager() instanceof Player) {
				
				Player player = (Player) event.getDamager();
				
				
				
				player.sendMessage(ChatColor.GRAY + "Boss has " + ChatColor.RED + (int)giant.getHealth() + ".0");
				double randDouble = Math.random();
				if(randDouble <= 0.25) {
					player.setVelocity(player.getVelocity().setX(2));
					player.setVelocity(player.getVelocity().setZ(2));
				}
				
				if(giant.getHealth() <= 100.0) {
					
					for(Entity e : giant.getLocation().getChunk().getEntities()) {
						if(e instanceof Giant) {
							e.setGlowing(true);
						}
						if(e instanceof Player) {
							e.setFireTicks(20*5);
							e.getWorld().strikeLightning(e.getLocation());
							e.sendMessage(ChatColor.RED + "BURN");
						}
							
					}
				}
				
				
			
				
			}
				
			}
			}
		
		}
	
	@EventHandler
	public void onBossArrowDamage(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Giant) {
			Giant giant = (Giant) event.getEntity();
			if(giant.getCustomName().contains("Fire Boss")) {
			if(event.getDamager() instanceof Arrow) {
				Arrow arrow = (Arrow) event.getDamager();
				Player player = (Player) arrow.getShooter();
				
				giant.getLocation();
				player.sendMessage(ChatColor.GRAY + "Boss has " + ChatColor.RED + (int)giant.getHealth() + ".0");
				
				double randChance = Math.random();
				if(randChance <= 0.25D) {
					player.setVelocity(player.getVelocity().setY(2));
					
				}
				
				double randChance1 = Math.random();
				if(randChance1 <= 0.35) {
					
					
					new BukkitRunnable() {
						double t = 30;
						public void run() {
							t += 0.5;
							Fireball fireball = giant.launchProjectile(Fireball.class);
							fireball.setVelocity(giant.getLocation().getDirection().multiply(3));
							if(t >= 35) {
								this.cancel();
							}
							
						}
						
					}.runTaskTimer(Main.getInstance(), 0, 1);
					
					
				}
				
				if(giant.getHealth() <= 100.0) {
					
					for(Entity e : giant.getLocation().getChunk().getEntities()) {
						if(e instanceof Giant) {
							e.setGlowing(true);
						}
						if(e instanceof Player) {
							e.setVelocity(e.getVelocity().setY(3));
							e.getWorld().strikeLightning(e.getLocation());
							e.sendMessage(ChatColor.RED + "DESTROY!");
						}
							
					}
					
					if(randChance1 <= 0.75D) {
						
						
						new BukkitRunnable() {
							double t = 15;
							public void run() {
								t += 0.5;
								Fireball fireball = giant.launchProjectile(Fireball.class);
								fireball.setVelocity(giant.getLocation().getDirection().multiply(3));
								if(t >= 35) {
									this.cancel();
								}
								
							}
							
						}.runTaskTimer(Main.getInstance(), 0, 1);
						
						
					}
					
					
					
					
				}
				
			}
				
				
			}
				
			}
		}
	
	
	//Wind Giant
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onwBossDamage(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			if(zombie.getCustomName().contains("Wind Boss")){
			if(event.getDamager() instanceof Player) {
				
				Player player = (Player) event.getDamager();
				player.damage(2);
				
				
				player.sendMessage(ChatColor.GRAY + "Boss has " + ChatColor.RED + (int)zombie.getHealth() + ".0");
				double randDouble = Math.random();
				if(randDouble <= 0.35D) {
					player.setVelocity(player.getLocation().getDirection().multiply(-2));
				}
				if(randDouble <= 0.23D) {
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*10, 127));
				}
				if(randDouble <= 0.10D) {
					
					AreaEffectCloud windCircle = (AreaEffectCloud) zombie.getWorld().spawnEntity(zombie.getLocation(), EntityType.AREA_EFFECT_CLOUD);
					windCircle.setRadius(5);
					windCircle.setWaitTime(0);
					windCircle.setDuration(60);
					windCircle.setCustomName("Wind Circle");
					windCircle.setCustomNameVisible(false);
					windCircle.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.WHITE, 5));
					if(player.getLocation().distance(windCircle.getLocation()) < 5.0) {
						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_SPLASH_HIGH_SPEED, 1.0F, 1.0F);
						player.setVelocity(player.getLocation().getDirection().multiply(-5));
					}
				}
				
				if(zombie.getHealth() <= 100.0) {
					zombie.setGlowing(true);
					
					new BukkitRunnable() {
						
						double t = 0;
						public void run() {
							t += 1;
							
							if(player.getLocation().distance((zombie.getLocation())) < 15.0) {
								player.setVelocity(player.getLocation().getDirection().multiply(5));
								player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*5, 2));
							}
							
							if(t >= 40) {
								this.cancel();
							}
							
							
						}
						
					}.runTaskTimer(Main.getInstance(), 0, 1);
					
				}
				
				
				
				if(randDouble <= 0.12D) {
					  FallingBlock block = zombie.getWorld().spawnFallingBlock(zombie.getLocation().add(new Vector(0, 3, 0)), Material.STONE, (byte) 0);
					  
		
					  block.setVelocity(zombie.getLocation().getDirection().multiply(2));
					  
					  
					  new BukkitRunnable() {
						  
						  public void run() {
							  if(block.isOnGround()) {
								   new BukkitRunnable(){
						              double t = 0;
						                public void run(){
						                	t += 1.5;
						                  drawTornado(block.getLocation(), 2, 0);
						                  if(t >= 40) {
						                	  this.cancel();
						                  }
						                  if(player.getLocation().distance(block.getLocation()) < 10.0) {
											  player.getWorld().createExplosion(player.getLocation(), 2);
											  player.getWorld().strikeLightning(player.getLocation());
											  player.getWorld().strikeLightning(player.getLocation());
											  player.damage(3.0);
										  }
						                }
						                
						            }.runTaskTimer(Main.getInstance(), 0, 1);
							  }
						  }
						  
						  
					  }.runTaskLater(Main.getInstance(), 20);
					  
					 
					    
					  
					  
				}
				
				
				
			}
		}
		}
		
		}
	
	
	  @EventHandler
	  public void onwShoot(EntityDamageByEntityEvent event) {
		  if(event.getEntity() instanceof Zombie) {
				Zombie zombie = (Zombie) event.getEntity();
				if(zombie.getCustomName().contains("Wind Boss")) {
				if(event.getDamager() instanceof Arrow) {
					Arrow arrow = (Arrow) event.getDamager();
					Player player = (Player) arrow.getShooter();
					
					player.setVelocity(player.getLocation().getDirection().multiply(-2));
					player.sendMessage(ChatColor.GRAY + "Boss has " + ChatColor.RED + (int)zombie.getHealth() + ".0");
				}
		  }
		  }
	  }

	public void drawTornado(Location loc, float radius,float increase){
        float y = (float) loc.getY();
        for(double t = 0; t<50; t+=0.05){
            float x = radius*(float)Math.sin(t);
            float z = radius*(float)Math.cos(t);
           loc.getWorld().spawnParticle(Particle.CLOUD, (float) loc.getX() + x, y,(float) loc.getZ() + z, 0, 0, 0, 0, 1);
            y += 0.01f;
            radius += increase;
        }
	}
	
	//Death
	
	
	

	@EventHandler
	public void onGiantDie(EntityDeathEvent event) {
		if(event.getEntity() instanceof Giant) {
			Giant giant = (Giant) event.getEntity();
			Player killer = (Player) event.getEntity().getKiller();
			Bukkit.broadcastMessage(ChatColor.GRAY + "The Boss was defeated by... " + ChatColor.GOLD + "" + event.getEntity().getKiller().getDisplayName() + "");
		}
	}
	

}
