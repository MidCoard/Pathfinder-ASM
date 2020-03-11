package com.focess.pathfinder.goal;

import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;

public class FocessGoalItem extends GoalItem {

    private final Goal goal;

    public FocessGoalItem(Goal goal) {
        super(goal.getClass());
        this.goal = goal;
    }

    @Override
    public WrappedGoal build(int priority) {

    }
}
