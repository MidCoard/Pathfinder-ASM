package com.focess.pathfinder.goal;

public class WrappedGoal {

    private final GoalItem goalItem;
    private final Object nmsGoal;

    public WrappedGoal(GoalItem goalItem, Object nmsGoal) {
        this.goalItem = goalItem;
        this.nmsGoal = nmsGoal;
    }


}
