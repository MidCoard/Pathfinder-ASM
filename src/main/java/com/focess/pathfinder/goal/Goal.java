package com.focess.pathfinder.goal;

import java.util.EnumSet;

public abstract class Goal {

    private final EnumSet<Control> controls = EnumSet.noneOf(Control.class);
    private GoalItem goalItem;

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

    public Goal addControl(Control control) {
        controls.add(control);
        return this;
    }

    public EnumSet<Control> getControls(){
        return this.controls;
    }

    public GoalItem getGoalItem() {
        return this.goalItem;
    }

    protected void setGoalItem(GoalItem goalItem) {
        this.goalItem = goalItem;
    }

    public enum Control {

        MOVE(1),
        LOOK(2),
        JUMP(4),
        TARGET(8);
        private final int value;

        Control(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
