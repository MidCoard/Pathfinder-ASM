package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.util.NMSManager;

public class FocessGoalItem extends GoalItem {

    private final Goal goal;

    public FocessGoalItem(Goal goal) {
        super(goal.getClass());
        this.goal = goal;
        this.goal.setGoalItem(this);
    }

    @Override
    public WrappedGoal build(int priority,boolean isTarget) {
        try {
            Object nmsGoal = PathfinderClassLoader.NMSGoal.getConstructor(Goal.class).newInstance(this.goal);
            if (NMSManager.isHighVersion())
                NMSManager.PathfinderGoalMutex.invoke(nmsGoal,NMSManager.toNMSControls(this.goal.getControls()));
            else {
                int value = 0;
                for (Goal.Control control:this.goal.getControls())
                    value += control.getValue();
                NMSManager.PathfinderGoalMutex.invoke(nmsGoal,value);
            }
            return new WrappedGoal(this,nmsGoal,priority,isTarget);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
