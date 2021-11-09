package com.darkenedfusion;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntitySkeleton;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EnumItemSlot;

public class CustomMiner extends EntitySkeleton {
	

	public CustomMiner(Location loc) {
		super(EntityTypes.SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setCustomName(new ChatComponentText("Miner"));
		this.setCustomNameVisible(false);
		this.setHealth(25);
		this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(new ItemStack(Material.STONE_PICKAXE)));
		this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(new ItemStack(Material.IRON_HELMET)));
	}



}
