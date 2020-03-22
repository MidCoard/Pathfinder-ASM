package com.focess.pathfinder.entity;

import com.focess.pathfinder.core.navigation.Navigation;
import com.focess.pathfinder.core.navigation.NavigationManager;
import com.focess.pathfinder.goal.GoalSelector;
import org.bukkit.entity.Entity;

public interface FocessEntity {

    GoalSelector getGoalSelector();

    Entity getBukkitEntity();

    NavigationManager getNavigationManager();

}
