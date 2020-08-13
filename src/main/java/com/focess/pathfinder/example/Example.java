package com.focess.pathfinder.example;


import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.Bukkit;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;

import java.lang.reflect.InvocationTargetException;

public class Example implements Listener {

//    @EventHandler
//    public void onCreatureSpawn(CreatureSpawnEvent event) {
//        if (event.getEntity() instanceof Sheep) {
//            FocessEntity entity = EntityManager.getFocessEntity(event.getEntity());
//            entity.getGoalSelector().addGoal(new FocessGoalItem(new SpiderNetGoal((Sheep) event.getEntity())).build(0,false));
////            entity.getGoalSelector().addGoal();
//        }
//        if (event.getEntity() instanceof Spider) {
//            FocessEntity entity = EntityManager.getFocessEntity(event.getEntity());
//            for (GoalItem goalItem:entity.getGoalSelector().getGoalItems())
//                for (WrappedGoal wrappedGoal:entity.getGoalSelector().getGoal(goalItem))
//                    System.out.println(wrappedGoal.getNmsGoal().getClass());
//        }
//    }

    public Example() {
        try {
            SimpleCommandMap commandMap = (SimpleCommandMap) NMSManager.getMethod(NMSManager.getCraftClass("CraftServer"),"getCommandMap").invoke(Bukkit.getServer());
            commandMap.register("PathfinderAPI",new ExampleCommand());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}