package com.focess.pathfinder.core;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.navigation.NavigationManager;
import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderPlugin extends JavaPlugin {
	private static PathfinderPlugin plugin;

	@Override
    public void onEnable() {
        if (NMSManager.getVersionInt() < 8) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
		this.plugin=this; 
        PathfinderClassLoader.loadClasses(this.getClassLoader());
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(),0L,20L);
        NavigationManager.INSTANCE.init();
//        this.getServer().getPluginManager().registerEvents(new Example(),this);
    }

	@Override
    public void onDisable() {

    }

	public static PathfinderPlugin getPlugin() {
		return plugin;
	}
}
