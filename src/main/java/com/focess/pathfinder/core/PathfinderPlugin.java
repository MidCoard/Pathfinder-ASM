package com.focess.pathfinder.core;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.goal.NMSGoalDump;
import com.focess.pathfinder.core.runnable.ExceptionRunnable;
import com.focess.pathfinder.example.Example;
import com.focess.pathfinder.goals.builder.TextGoalsBuilder;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class PathfinderPlugin extends JavaPlugin {

    public void onEnable() {
        PathfinderClassLoader.loadClasses();
        this.getServer().getScheduler().runTaskTimerAsynchronously(this, new ExceptionRunnable(),0L,20L);
//        this.getServer().getPluginManager().registerEvents(new Example(),this);
        try {
            TextGoalsBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onDisable() {
    }
}
