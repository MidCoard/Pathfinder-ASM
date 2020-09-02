package com.focess.pathfinder.core;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.listener.EntityListener;
import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import com.focess.pathfinder.core.runnable.PathRunnable;
import com.focess.pathfinder.core.runnable.RecalculateRunnable;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.util.Requests;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderPlugin extends JavaPlugin {
    private static PathfinderPlugin plugin;

    public static PathfinderPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        if (NMSManager.getVersionInt() < 8) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.plugin = this;
        PathfinderClassLoader.loadClasses(this.getClassLoader());
        this.getServer().getPluginManager().registerEvents(new EntityListener(),this);
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(), 0L, 20L);
        this.getServer().getScheduler().runTaskTimer(this,new RecalculateRunnable(),0l,1l);
        this.getServer().getScheduler().runTaskTimer(this,new PathRunnable(),0l,1l);
        Requests.allocateRequestManager(this,3);
//        this.getServer().getPluginManager().registerEvents(new Example(),this);
    }

    @Override
    public void onDisable() {

    }
}
