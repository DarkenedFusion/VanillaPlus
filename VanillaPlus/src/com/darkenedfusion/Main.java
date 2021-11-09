package com.darkenedfusion;


import org.bukkit.plugin.java.JavaPlugin;

import elementalMobs.spawnZombie;

public class Main extends JavaPlugin {
	
	
	private static Main instance;
	
	
	
	
	
	@Override
	public void onEnable() {
		instance = this;
		this.getServer().getPluginManager().registerEvents(new MinerEvent(), this);
		this.getServer().getPluginManager().registerEvents(new spawnZombie(), this);
		this.getServer().getPluginManager().registerEvents(new adminItems(), this);
		this.getServer().getPluginManager().registerEvents(new customItems(), this);
		this.getServer().getPluginManager().registerEvents(new customEnchants(), this);
		this.getServer().getPluginManager().registerEvents(
				new SpawnEntity(), this);
		this.getCommand("spawnin").setExecutor(new spawnBoss());
		this.getServer().getPluginManager().registerEvents(new customMobs(), this);
		this.getCommand("give").setExecutor(new giveItem());
		
	}
	
	@Override
	public void onDisable() {
		
	}

	public static Main getInstance() {
        return instance;
    }
	
	

}
