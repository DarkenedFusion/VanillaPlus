package com.darkenedfusion;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_16_R3.WorldServer;

public class MinerEvent implements Listener {
	
	private static final String CFRAG_SKULL = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE1ZjI5YTc2ZDFmOTFjMTY1ZjYzYmFhYzA0ODY3MGU3YjFkMzdjZTc4NWE0ZDljMjFkOGMzYTE3N2I1In19fQ==";
	
	
	
	@EventHandler
	public void onOreBreak(BlockBreakEvent event) {
		if(!(event.getBlock().getType() == Material.COAL_ORE))
			return;
		
		double randDouble = Math.random();
		if(randDouble <= 0.05D) {
			CustomMiner miner = new CustomMiner(event.getPlayer().getLocation());
			WorldServer world = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
			world.addEntity(miner);
			
			
		}
	}
	
	
	
	
	
	
	@EventHandler
	public void crystalDrop(BlockBreakEvent event) {
		if(!(event.getBlock().getType() == Material.DIAMOND_ORE)) return;
		Block diamond_ore = event.getBlock();
		
		double randDouble = Math.random();
		if(randDouble <= 0.05D) {
			Player player = event.getPlayer();
			if(player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) return;
			
			ItemStack cFrag = SkullCreator.itemWithBase64(SkullCreator.createSkull(), CFRAG_SKULL);
			ItemMeta meta = cFrag.getItemMeta();
			meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Crystal Fragment");
			cFrag.setItemMeta(meta);
			
			
			diamond_ore.getWorld().dropItemNaturally(diamond_ore.getLocation(), cFrag);
		}
		if(event.getBlock().getType() == Material.EMERALD_ORE) {
			if(randDouble <= 0.10D) {
				Player player = event.getPlayer();
				if(player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) return;
				ItemStack cFrag = SkullCreator.itemWithBase64(SkullCreator.createSkull(), CFRAG_SKULL);
				ItemMeta meta = cFrag.getItemMeta();
				meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Crystal Fragment");
				cFrag.setItemMeta(meta);
				
				
				diamond_ore.getWorld().dropItemNaturally(diamond_ore.getLocation(), cFrag);
			}
		}
	}
	
	@EventHandler
	public void onPlaceCrystal(BlockPlaceEvent event) {
		ItemStack cFrag = SkullCreator.itemWithBase64(SkullCreator.createSkull(), CFRAG_SKULL);
		ItemMeta meta = cFrag.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Crystal Fragment");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		cFrag.setItemMeta(meta);
		if(event.getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.LIGHT_PURPLE + "Crystal Fragment")) {
			event.setCancelled(true);
		}
	}

	
	
	
}
