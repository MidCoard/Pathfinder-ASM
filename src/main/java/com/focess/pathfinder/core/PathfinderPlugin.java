package com.focess.pathfinder.core;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.goal.NMSGoalDump;
import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderPlugin extends JavaPlugin {

    public void onEnable() {
        PathfinderClassLoader.loadClasses();
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(),0L,20L);
    }

    public void onDisable() {
    }
}
