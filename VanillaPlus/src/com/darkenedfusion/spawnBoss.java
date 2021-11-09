package com.darkenedfusion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import elementalMobs.ElementalZombie;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.WorldServer;

public class spawnBoss implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if (label.equalsIgnoreCase("spawnin")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Console cannot run this command!");
				return true;
			}
			Player player = (Player) sender;
			if(player.hasPermission("*")) {
				if(args[0].equalsIgnoreCase("fboss")) {
			fCustomBoss boss = new fCustomBoss(player.getLocation());
			
			WorldServer world = ((CraftWorld)player.getLocation().getWorld()).getHandle();
			world.addEntity(boss);
				}
				if(args[0].equalsIgnoreCase("turkey")) {
					TurkeyAlpha alpha = new TurkeyAlpha(player.getLocation());
					
					WorldServer world = ((CraftWorld)player.getLocation().getWorld()).getHandle();
					world.addEntity(alpha);
				}
				if(args[0].equalsIgnoreCase("wboss")) {
					wCustomBoss boss = new wCustomBoss(player.getLocation());
					
					WorldServer world = ((CraftWorld)player.getLocation().getWorld()).getHandle();
					world.addEntity(boss);
				}
				
				if(args[0].equalsIgnoreCase("eZombie")) {
					ElementalZombie eZombie = new ElementalZombie(player.getLocation());
					WorldServer world = ((CraftWorld)player.getLocation().getWorld()).getHandle();
					world.addEntity(eZombie);
				}
		}
		
	}
		return false;
	}
}
