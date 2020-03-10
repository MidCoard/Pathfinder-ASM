package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.goal.FocessGoalItem;

import java.util.EnumSet;

public abstract class Goal  {

    private final EnumSet<Control> controls = EnumSet.noneOf(Control.class);
    private final int priority;

    public Goal(int priority) {
        this.priority = priority;
    }

    public abstract boolean canStart();

    public boolean shouldContinue() { return canStart(); }

    public boolean canStop() { return true; }

    public void start() {}

    public void stop() {}

    public void tick() {}

    public final void setControls(EnumSet<Control> controls) {
        this.controls.clear();
        this.controls.addAll(controls);
    }

    public final EnumSet<Control> getControls() { return this.controls; }

    public enum Control
    {

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
        return new FocessGoalItem(this);
    }
}
