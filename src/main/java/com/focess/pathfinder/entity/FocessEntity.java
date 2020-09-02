package com.focess.pathfinder.entity;

import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.navigation.Navigation;
import com.focess.pathfinder.navigation.NavigationManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.Random;

public interface FocessEntity {

    public Entity getBukkitEntity();

    GoalSelector getGoalSelector();

    int getID();

    NavigationManager getNavigationManager();

    Random getRandom();

    Location getLocation();

}
