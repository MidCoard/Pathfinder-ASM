package com.focess.pathfinder.goal;

import com.focess.pathfinder.goal.entity.FocessEntity;
import com.google.common.collect.Sets;

import java.util.Set;

public interface GoalSelector {

    Set<GoalItem> getGoalItems();

    default void removeGoal(GoalItem goalItem) {
        this.removeExactGoal(goalItem,null);
    }

    void removeExactGoal(GoalItem goalItem,Object object);

    void addGoal(Object object);

    default boolean containsGoal(GoalItem goalItem) {
        return this.containsExactGoal(goalItem,null);
    }

    boolean containsExactGoal(GoalItem goalItem,Object object);

    Object getGoal(GoalItem goalItem);

}
