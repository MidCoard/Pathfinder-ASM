package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.PathfinderUtil;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

public class WrappedGoal {

    private final List<GoalItem> goalItems;
    private EnumSet<Goal.Control> controls = EnumSet.noneOf(Goal.Control.class);

    public WrappedGoal(GoalItem goalItem, Object nmsGoal, int priority,boolean isTarget) {
        this(Lists.newArrayList(goalItem),nmsGoal,priority,isTarget);
    }

    public List<GoalItem> getGoalItems() {
        return goalItems;
    }

    public Object getNmsGoal() {
        return nmsGoal;
    }

    public int getPriority() {
        return priority;
    }

    private final Object nmsGoal;
    private final int priority;

    public WrappedGoal(List<GoalItem> goalItems, Object nmsGoal, int priority,boolean isTarget) {
        this.goalItems = goalItems;
        this.nmsGoal = nmsGoal;
        this.priority = priority;
        try {
            if (NMSManager.isHighVersion())
                this.controls = NMSManager.toFocessControls((Collection<?>) NMSManager.PathfinderGoalMutexGetter.invoke(nmsGoal));
            else
                this.controls = PathfinderUtil.toFocessControls((int) NMSManager.PathfinderGoalMutexGetter.invoke(nmsGoal),isTarget);
        } catch (Exception e) {
            throw new RuntimeException(e);
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
