package com.focess.pathfinder.example;


import com.focess.pathfinder.goal.FocessGoalItem;
import com.focess.pathfinder.entity.EntityManager;
import com.focess.pathfinder.entity.FocessEntity;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Example implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Spider) {
            FocessEntity entity = EntityManager.getFocessEntity(event.getEntity());
            entity.getGoalSelector().addGoal(new FocessGoalItem(new SpiderNetGoal((Spider) event.getEntity())).build(0));
//            entity.getGoalSelector().addGoal();
        }
    }

    public Example() {
    }

}
