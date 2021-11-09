package com.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityChicken;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;

public class TurkeyMembers extends EntityChicken {
	
	public TurkeyMembers(Location loc, String name) {
		super(EntityTypes.CHICKEN, ((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setHealth(350);
		
		this.setCustomNameVisible(true);
		this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&', name)));	
	}
	
	public void initPathfinder() {
		super.initPathfinder();
		this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
		this.goalSelector.a(1, new PathfinderGoalFollowLeader(this, 1.0));
	}
	
}