package com.focess.pathfinder.example;


import com.focess.pathfinder.entity.EntityManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.goal.FocessGoalItem;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.WrappedGoal;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Example implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Sheep) {
            FocessEntity entity = EntityManager.getFocessEntity(event.getEntity());
            entity.getGoalSelector().addGoal(new FocessGoalItem(new SpiderNetGoal((Sheep) event.getEntity())).build(0,false));
//            entity.getGoalSelector().addGoal();
        }
        if (event.getEntity() instanceof Spider) {
            FocessEntity entity = EntityManager.getFocessEntity(event.getEntity());
            for (GoalItem goalItem:entity.getGoalSelector().getGoalItems())
                for (WrappedGoal wrappedGoal:entity.getGoalSelector().getGoal(goalItem))
                    System.out.println(wrappedGoal.getNmsGoal().getClass());
        }
    }

    public Example() {
    }

}