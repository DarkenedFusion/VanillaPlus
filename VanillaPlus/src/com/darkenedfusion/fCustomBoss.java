package com.darkenedfusion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.minecraft.server.v1_16_R3.AttributeBase;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityChicken;
import net.minecraft.server.v1_16_R3.EntityGiantZombie;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityTurtle;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EnumItemSlot;
import net.minecraft.server.v1_16_R3.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStroll;

public class fCustomBoss extends EntityGiantZombie {
	
	public fCustomBoss(Location loc) {
		super(EntityTypes.GIANT, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setCustomName(new ChatComponentText(
				ChatColor.translateAlternateColorCodes('&', "&c&lFire Boss")));
		this.setCustomNameVisible(true);
		this.setHealth(1000);
		
		ItemStack fhelmet = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta meta = (LeatherArmorMeta) fhelmet.getItemMeta();
		meta.setColor(Color.RED);
		meta.setUnbreakable(true);
		fhelmet.setItemMeta(meta);
		
		
		ItemStack fchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta2 = (LeatherArmorMeta) fchestplate.getItemMeta();
		meta.setUnbreakable(true);
		meta2.setColor(Color.RED);
		fchestplate.setItemMeta(meta2);
		
		ItemStack fleggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta lmeta = (LeatherArmorMeta) fleggings.getItemMeta();
		lmeta.setColor(Color.RED);
		lmeta.setUnbreakable(true);
		fleggings.setItemMeta(lmeta);
		
		ItemStack fboots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bmeta = (LeatherArmorMeta) fboots.getItemMeta();
		bmeta.setColor(Color.RED);
		bmeta.setUnbreakable(true);
		fboots.setItemMeta(bmeta);
		
		ItemStack fireSword = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta5 = fireSword.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Fire Blade");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item Ability:");
		lore.add(ChatColor.RED + "Right Click: Shoots a blast of fire!");
		lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "One of the 4 Legendary Swords!");
		meta5.setLore(lore);
		fireSword.setItemMeta(meta5);
		
		this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(fhelmet));
		this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(fchestplate));
		this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(fleggings));
		this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(fboots));
		this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(fireSword));
		
		
	}
	
	@Override
	public void initPathfinder() {
		this.goalSelector.a(0, new PathfinderGoalFloat(this));
		
		this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 0.5D, true));
		this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.5D));
		this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 0.5D, false, 1, null));
		this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 0.5D));
		this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
		this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		
		this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
		
		
	}

}
