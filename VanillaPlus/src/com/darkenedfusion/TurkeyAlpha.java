package com.darkenedfusion;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityChicken;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityWolf;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.WorldServer;

public class TurkeyAlpha extends EntityChicken {
	
	public TurkeyAlpha(Location loc) {
		super(EntityTypes.CHICKEN, ((CraftWorld)loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setHealth(500);
		this.setCustomNameVisible(true);
		this.setCustomName(new ChatComponentText(
				ChatColor.translateAlternateColorCodes('&', "&6&lAlpha Chicken")));
		
		spawnMembers(loc);
	}
	
	public void initPathfinder() {
		super.initPathfinder();
		this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<EntityHuman>(
				this, EntityHuman.class, true));
		this.goalSelector.a(1, new PathfinderGoalNearestAttackableTarget<TurkeyAlpha>(
				this, TurkeyAlpha.class, false));
	}
	
	private void spawnMembers(Location loc) {
		List<TurkeyMembers> pack = Arrays.asList(
				new TurkeyMembers(loc, "&fGamer Turkey"),
				new TurkeyMembers(loc, "&fEpic Turkey"),
				new TurkeyMembers(loc, "&fDerp Turkey"),
				new TurkeyMembers(loc, "&fTurkey Turkey"));
		
		WorldServer world = ((CraftWorld)loc.getWorld()).getHandle();
		for (TurkeyMembers wolf : pack) 
			world.addEntity(wolf);
	}

}
