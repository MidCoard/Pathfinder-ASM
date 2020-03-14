package com.focess.pathfinder.entity;

import com.focess.pathfinder.goal.GoalSelector;
import org.bukkit.entity.Entity;

public interface FocessEntity {

    GoalSelector getGoalSelector();

    Entity getBukkitEntity();
}
