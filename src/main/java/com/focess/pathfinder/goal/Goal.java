package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.goal.FocessGoalItem;
import com.focess.pathfinder.core.goal.NMSGoalItem;

import java.util.EnumSet;
import java.util.Objects;

public abstract class Goal {

    private final EnumSet<Control> controls = EnumSet.noneOf(Control.class);
    private Object nmsGoal;

    private int priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        Goal goal = (Goal) o;
        if (goalItem instanceof NMSGoalItem && goalItem.equals(goalItem) && nmsGoal.equals(goal.nmsGoal))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    private final GoalItem goalItem;

    public Goal() {
        this(0);
    }

    public Goal(int priority) {
        this(null, priority);
    }

    public Goal(GoalItem goalItem, int priority) {
        this.goalItem = goalItem;
        this.priority = priority;
    }

    public Goal(NMSGoalItem goalItem, int priority, Object nmsGoal) {
        this.priority = priority;
        this.goalItem = goalItem;
        this.nmsGoal = nmsGoal;
    }

    public abstract boolean canStart();

    public boolean shouldContinue() {
        return canStart();
    }

    public boolean canStop() {
        return true;
    }

    public void start() {
    }

    public void stop() {
    }

    public void tick() {
    }

    public final void setControls(EnumSet<Control> controls) {
        this.controls.clear();
        this.controls.addAll(controls);
    }

    public final EnumSet<Control> getControls() {
        return this.controls;
    }

    public enum Control {

        MOVE(1),
        LOOK(2),
        JUMP(4),
        TARGET(8);
        private final int value;

        private Control(int value) {
            this.value = value;
        }
    }

    public final GoalItem toGoalItem() {
        if (this.goalItem != null)
            return this.goalItem;
        return new FocessGoalItem(this);
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}
