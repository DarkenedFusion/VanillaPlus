package com.darkenedfusion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class giveItem implements CommandExecutor {
	private static final String RLAUNCHER = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM0ZWIzNTZiNTc1MjEyYTkyMWFiNzg2MTY4MzIxZmVhNDc2ZTRiYmQzYzFiNmE2N2Y1YTRiYTA5MTM1M2EifX19";
		public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
			if (label.equalsIgnoreCase("give")) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("Console cannot run this command!");
					return true;
				}
				Player player = (Player) sender;
				if(args[0].equalsIgnoreCase("storm")) {
					ItemStack stormBow = new ItemStack(Material.BOW);
					ItemMeta meta = stormBow.getItemMeta();
					meta.setDisplayName(ChatColor.BLUE + "Eye of the Storm");
					meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
					meta.addEnchant(Enchantment.DURABILITY, 3, true);
					stormBow.setItemMeta(meta);
					player.getInventory().addItem(stormBow);
				}
				if(args[0].equalsIgnoreCase("wind")) {
					ItemStack windSword = new ItemStack(Material.IRON_SWORD);
					ItemMeta meta = windSword.getItemMeta();
					meta.setDisplayName(ChatColor.GRAY + "Wind Blade");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Item Ability:");
					lore.add(ChatColor.DARK_AQUA + "Right Click: Shoots a gust of wind.");
					lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "One of the 4 Legendary Swords!");
					meta.setLore(lore);
					windSword.setItemMeta(meta);
					
					player.getInventory().addItem(windSword);
				}
				
				if(args[0].equalsIgnoreCase("ice")) {
					ItemStack iceSword = new ItemStack(Material.IRON_SWORD);
					ItemMeta meta = iceSword.getItemMeta();
					meta.setDisplayName(ChatColor.AQUA + "Ice Blade");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "Item Ability:");
					lore.add(ChatColor.AQUA + "Right Click: Has a chance to freeze enemies!");
					lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "One of the 4 Legendary Swords!");
					meta.setLore(lore);
					iceSword.setItemMeta(meta);
					
					player.getInventory().addItem(iceSword);
				}
				
				if(args[0].equalsIgnoreCase("Fire")) {
					ItemStack fireSword = new ItemStack(Material.IRON_SWORD);
					ItemMeta meta = fireSword.getItemMeta();
					meta.setDisplayName(ChatColor.RED + "Fire Blade");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Item Ability:");
					lore.add(ChatColor.RED + "Right Click: Shoots a blast of fire!");
					lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "One of the 4 Legendary Swords!");
					meta.setLore(lore);
					fireSword.setItemMeta(meta);
					
					player.getInventory().addItem(fireSword);
				}
				
				if(args[0].equalsIgnoreCase("Earth")) {
					ItemStack earthSword = new ItemStack(Material.IRON_SWORD);
					ItemMeta meta = earthSword.getItemMeta();
					meta.setDisplayName(ChatColor.DARK_GREEN + "Earth Blade");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "Item Ability:");
					lore.add(ChatColor.DARK_GREEN + "Right Click: Throws a rock at an enemy!");
					lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "One of the 4 Legendary Swords!");
					meta.setLore(lore);
					earthSword.setItemMeta(meta);
					
					player.getInventory().addItem(earthSword);
				}
				if(args[0].equalsIgnoreCase("rLauncher")) {
					ItemStack rLauncher = SkullCreator.itemWithBase64(SkullCreator.createSkull(), RLAUNCHER);
					ItemMeta meta = rLauncher.getItemMeta();
					meta.setDisplayName(ChatColor.GOLD + "Rocket Launcher");
					List<String> lore = new ArrayList<String>();
					lore.add(ChatColor.YELLOW + "" + ChatColor.BOLD + "Item Ability:");
					lore.add(ChatColor.GRAY + "Right Click: Shoots a rocket!");
					lore.add(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Admin Item.");
					meta.setLore(lore);
					rLauncher.setItemMeta(meta);
					
					player.getInventory().addItem(rLauncher);
				}
				
			}
			return false;
		}


		
}


