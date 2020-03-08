package com.focess.pathfinder;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PathfinderPlugin extends JavaPlugin {
    public void onEnable() {

    }

    public void onDisable() {
        Player player;
        player.damage(2,null);
    }
}
