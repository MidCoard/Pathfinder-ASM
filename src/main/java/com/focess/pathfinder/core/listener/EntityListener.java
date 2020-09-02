package com.focess.pathfinder.core.listener;

import com.focess.pathfinder.core.entity.NMSFocessEntity;
import com.focess.pathfinder.entity.EntityManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EntityListener implements Listener {

    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event) {
        EntityManager.register(event.getEntity(),new NMSFocessEntity(event.getEntity()));
    }
}
