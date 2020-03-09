package com.focess.pathfinder.goal;

import java.util.EnumSet;

public abstract class Goal  {

    private final EnumSet<Control> controls = EnumSet.noneOf(Control.class);

    public abstract boolean canStart();

    public boolean shouldContinue() { return canStart(); }

    public boolean canStop() { return true; }

    public void start() {}

    public void stop() {}

    public void tick() {}

    public void setControls(EnumSet<Control> controls) {
        this.controls.clear();
        this.controls.addAll(controls);
    }

    public EnumSet<Control> getControls() { return this.controls; }

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
}
