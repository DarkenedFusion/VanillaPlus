package elementalMobs;

import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_16_R3.WorldServer;

public class spawnZombie implements Listener {
	
	@EventHandler
	public void randomSpawn(EntitySpawnEvent event) {
		if(!(event.getEntity() instanceof Zombie)) {
			return;
		}
		if(event.getLocation().getBlock().isLiquid()) {
			return;
		}
		
		double random = Math.random();
		if(random <= 0.005D) {
			event.setCancelled(true);
			
			ElementalZombie eZombie = new ElementalZombie(event.getLocation());
			WorldServer world = ((CraftWorld)event.getLocation().getWorld()).getHandle();
			world.addEntity(eZombie);
			
			
		}
		
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void oneZombieSpawn(EntitySpawnEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			if(zombie.getCustomName().contains("Elemental Zombie")) {
				zombie.setMaxHealth(40.0);
				zombie.setHealth(40.0);
			}
		}
	}
	
	@EventHandler
	public void onZombieHit(EntityDamageByEntityEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
			System.out.println("Got the zombie");
			if(zombie.getCustomName().contains("Elemental Zombie")) {
				System.out.println("Got the e zombie");
			if(event.getDamager() instanceof Player) {
				System.out.println("Got the player");
				Player player = (Player) event.getEntity();
				
				
				zombie.teleport(zombie.getLocation().add(new Vector(5, 0, 5)));
				
			}
		}
		}
	}

}
