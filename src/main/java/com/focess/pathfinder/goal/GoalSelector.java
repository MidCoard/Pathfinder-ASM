package com.focess.pathfinder.goal;

import com.focess.pathfinder.goal.entity.FocessEntity;
import com.google.common.collect.Sets;

import java.util.Set;

public interface GoalSelector {

    Set<GoalItem> getGoalItems();

    default void removeGoal(GoalItem goalItem) {
        this.removeExactGoal(goalItem,null);
    }

    default boolean containsGoal(GoalItem goalItem) {
        return this.containsExactGoal(goalItem,null);
    }

    void removeExactGoal(GoalItem goalItem, Goal goal);

    void addGoal(Goal goal);

    boolean containsExactGoal(GoalItem goalItem, Goal goal);

    Object getGoal(GoalItem goalItem);

}
