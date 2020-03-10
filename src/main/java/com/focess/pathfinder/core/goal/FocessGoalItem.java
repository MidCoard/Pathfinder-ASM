package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;

public class FocessGoalItem extends GoalItem {

    public FocessGoalItem(Goal goal) {
        super(GoalType.FOCESS);
        for (Goal.Control control:goal.getControls())
            this.addControl(control);
    }

    @Override
    public Object build(Object... objects) {
        throw new UnsupportedOperationException("FocessGoal cannot be build.");
    }
}
