package com.focess.pathfinder.example;


import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.Goals;
import com.focess.pathfinder.goal.entity.EntityManager;
import com.focess.pathfinder.goal.entity.FocessEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Example {

    public Example() {
        Goal goal = Goals.MOVE.ArrowAttack.clear().writeDouble(1d).build(10);
        Player player = Bukkit.getPlayer("MidCoard");
        FocessEntity entity = EntityManager.getFocessEntity(player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE));
        entity.getGoalSelector().addGoal(null);
    }

}
