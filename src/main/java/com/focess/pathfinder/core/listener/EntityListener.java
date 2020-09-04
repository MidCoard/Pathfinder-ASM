package com.focess.pathfinder.core.listener;

import com.focess.pathfinder.core.entity.NMSFocessEntity;
import com.focess.pathfinder.entity.EntityManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EntityListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST,ignoreCancelled = true)
    public void onEntitySpawn(CreatureSpawnEvent event) {
        EntityManager.register(event.getEntity(),new NMSFocessEntity(event.getEntity()));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        EntityManager.register(event.getPlayer(),new NMSFocessEntity(event.getPlayer()));
    }
}
