package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.PathfinderUtil;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Objects;

public class WrappedGoal {

    private final GoalItem goalItem;
    private EnumSet<Goal.Control> controls = EnumSet.noneOf(Goal.Control.class);

    public GoalItem getGoalItem() {
        return goalItem;
    }

    public Object getNmsGoal() {
        return nmsGoal;
    }

    public int getPriority() {
        return priority;
    }

    private final Object nmsGoal;
    private final int priority;

    public WrappedGoal(GoalItem goalItem, Object nmsGoal, int priority) {
        this.goalItem = goalItem;
        this.nmsGoal = nmsGoal;
        this.priority = priority;
        try {
            if (NMSManager.isHighVersion())
                this.controls = NMSManager.toFocessControls((Collection<?>) NMSManager.PathfinderGoalMutexGetter.invoke(nmsGoal));
            else
                this.controls = PathfinderUtil.toFocessControls((int) NMSManager.PathfinderGoalMutexGetter.invoke(nmsGoal));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrappedGoal)) return false;
        WrappedGoal that = (WrappedGoal) o;
        return Objects.equals(nmsGoal, that.nmsGoal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nmsGoal);
    }

    public EnumSet<Goal.Control> getControls() {
        return this.controls;
    }
}
