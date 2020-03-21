package com.focess.pathfinder.core;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import com.focess.pathfinder.example.Example;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderPlugin extends JavaPlugin {

    public void onEnable() {
        PathfinderClassLoader.loadClasses();
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(),0L,20L);
        this.getServer().getPluginManager().registerEvents(new Example(),this);
    }

    public void onDisable() {
    }
}
