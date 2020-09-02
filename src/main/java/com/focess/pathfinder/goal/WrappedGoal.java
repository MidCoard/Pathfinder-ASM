package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.core.util.NMSObject;
import com.focess.pathfinder.core.util.PathfinderUtil;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

public class WrappedGoal implements NMSObject {

    private final List<GoalItem> goalItems;
    private final Object nmsGoal;
    private final int priority;
    private final Object goal;
    private EnumSet<Goal.Control> controls = EnumSet.noneOf(Goal.Control.class);

    public WrappedGoal(GoalItem goalItem, Object nmsGoal, int priority, boolean isTarget) {
        this(goalItem, nmsGoal, nmsGoal, priority, isTarget);
    }

    public WrappedGoal(GoalItem goalItem, Object nmsGoal,Object goal, int priority, boolean isTarget) {
        this(Lists.newArrayList(goalItem), nmsGoal,goal, priority, isTarget);
    }
    public WrappedGoal(List<GoalItem> goalItems, Object nmsGoal, int priority, boolean isTarget) {
        this(goalItems,nmsGoal,nmsGoal,priority,isTarget);
    }

    public WrappedGoal(List<GoalItem> goalItems, Object nmsGoal,Object goal, int priority, boolean isTarget) {
        this.goalItems = goalItems;
        this.nmsGoal = nmsGoal;
        this.priority = priority;
        this.goal = goal;
        try {
            if (NMSManager.isHighVersion())
                this.controls = NMSManager.toFocessControls((Collection<?>) NMSManager.PathfinderGoalMutexGetter.invoke(nmsGoal));
            else
                this.controls = PathfinderUtil.toFocessControls((int) NMSManager.PathfinderGoalMutexGetter.invoke(nmsGoal), isTarget);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<GoalItem> getGoalItems() {
        return goalItems;
    }

    @Override
    public Object toNMS() {
        return nmsGoal;
    }

    public int getPriority() {
        return priority;
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

    public Object getGoal() {
        return this.goal;
    }
}
