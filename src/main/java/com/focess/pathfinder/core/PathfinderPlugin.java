package com.focess.pathfinder.core;

import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderPlugin extends JavaPlugin {

    public void onEnable() {
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(),0L,20L);
    }

    public void onDisable() {
    }
}
