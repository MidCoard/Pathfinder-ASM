package com.focess.pathfinder.entity;

import com.focess.pathfinder.navigation.Navigation;
import com.focess.pathfinder.goal.GoalSelector;
import org.bukkit.entity.Entity;

import java.util.Random;

public interface FocessEntity {

    GoalSelector getGoalSelector();

    Entity getBukkitEntity();

    int getID();

    Navigation getNavigationManager();

    Random getRandom();

}
