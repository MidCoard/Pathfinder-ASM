package com.focess.pathfinder.goal;

public class NamedGoalItem extends GoalItem {

    public NamedGoalItem(String id) {
        super(FocessGoalItem.goalTypes.get(id));
    }

    @Override
    public WrappedGoal build(int priority, boolean isTarget) {
        throw new UnsupportedOperationException();
    }
}
