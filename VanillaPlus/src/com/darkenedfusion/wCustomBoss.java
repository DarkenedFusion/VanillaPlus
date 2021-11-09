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

import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityGiantZombie;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityZombie;
import net.minecraft.server.v1_16_R3.EnumItemSlot;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStroll;

public class wCustomBoss extends EntityZombie {
	
	public wCustomBoss(Location loc) {
		super(EntityTypes.ZOMBIE, ((CraftWorld) loc.getWorld()).getHandle());
		
		this.setPosition(loc.getX(), loc.getY(), loc.getZ());
		
		this.setCustomName(new ChatComponentText(
				ChatColor.translateAlternateColorCodes('&', "&7&lWind Boss")));
		this.setCustomNameVisible(true);
		this.setHealth(1500);
		
		ItemStack fhelmet = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta meta = (LeatherArmorMeta) fhelmet.getItemMeta();
		meta.setColor(Color.GRAY);
		meta.setUnbreakable(true);
		fhelmet.setItemMeta(meta);
		
		
		ItemStack fchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta2 = (LeatherArmorMeta) fchestplate.getItemMeta();
		meta.setUnbreakable(true);
		meta2.setColor(Color.GRAY);
		fchestplate.setItemMeta(meta2);
		
		ItemStack fleggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta lmeta = (LeatherArmorMeta) fleggings.getItemMeta();
		lmeta.setColor(Color.GRAY);
		lmeta.setUnbreakable(true);
		fleggings.setItemMeta(lmeta);
		
		ItemStack fboots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta bmeta = (LeatherArmorMeta) fboots.getItemMeta();
		bmeta.setColor(Color.GRAY);
		bmeta.setUnbreakable(true);
		fboots.setItemMeta(bmeta);
		
		ItemStack windSword = new ItemStack(Material.IRON_SWORD);
		ItemMeta meta8 = windSword.getItemMeta();
		meta.setDisplayName(ChatColor.GRAY + "Wind Blade");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Item Ability:");
		lore.add(ChatColor.DARK_AQUA + "Right Click: Shoots a gust of wind.");
		lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "One of the 4 Legendary Swords!");
		meta8.setLore(lore);
		windSword.setItemMeta(meta8);
		
		this.setSlot(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(fhelmet));
		this.setSlot(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(fchestplate));
		this.setSlot(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(fleggings));
		this.setSlot(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(fboots));
		this.setSlot(EnumItemSlot.MAINHAND, CraftItemStack.asNMSCopy(windSword));
		
		
	}
	
	@Override
	public void initPathfinder() {
		this.goalSelector.a(0, new PathfinderGoalFloat(this));
		
		this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 2.0D, true));
		this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 2.0D));
		this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 2.0D, false, 1, null));
		this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 2.0D));
		this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
		this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		
		this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
		
		
	}

}
