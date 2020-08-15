package com.focess.pathfinder.entity;

import java.util.Random;

import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.navigation.NMSNavigation;

public interface INMSFocessEntity extends IFocessEntity{
    GoalSelector getGoalSelector();
    
    int getID();

    NMSNavigation getNavigationManager();

    Random getRandom();
}
