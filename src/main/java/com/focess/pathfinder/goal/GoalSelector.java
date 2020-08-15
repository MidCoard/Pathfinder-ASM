package com.focess.pathfinder.goal;

import java.util.List;
import java.util.Set;

public interface GoalSelector {

    Set<GoalItem> getGoalItems();

    void removeGoal(GoalItem goalItem);

    boolean containsGoal(GoalItem goalItem);

    void removeExactGoal(WrappedGoal goal);

    void addGoal(WrappedGoal goal);

    boolean containsExactGoal(WrappedGoal goal);

    List<WrappedGoal> getGoal(GoalItem goalItem);

    List<WrappedGoal> getGoals();
}
