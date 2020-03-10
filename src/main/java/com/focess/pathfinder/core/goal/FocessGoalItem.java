package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;

public class FocessGoalItem extends GoalItem {

    public FocessGoalItem(Goal goal) {
        super(GoalType.FOCESS,goal.getClass());
        for (Goal.Control control:goal.getControls())
            this.addControl(control);
    }

    @Override
    public Goal build(int priority) {
        throw new UnsupportedOperationException("FocessGoal cannot be built.");
    }
}
