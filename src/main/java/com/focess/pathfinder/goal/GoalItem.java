package com.focess.pathfinder.goal;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

public abstract class  GoalItem {

    private final GoalType type;
    private final Class<?> clz;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoalItem)) return false;
        GoalItem goalItem = (GoalItem) o;
        return type == goalItem.type &&
                Objects.equals(clz, goalItem.clz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, clz);
    }

    public EnumSet<Goal.Control> getControls() {
        return controls;
    }

    private EnumSet<Goal.Control> controls = EnumSet.noneOf(Goal.Control.class);

    protected GoalItem(GoalType type, Class<?> clz) {
        this.type = type;
        this.clz = clz;
        if (this.type == GoalType.NMS)
            Goals.goalItems.add(this);
    }

    protected GoalItem addControl(Goal.Control control) {
        controls.add(control);
        return this;
    }

    public Class<?> getGoalClass(){
        return this.clz;
    }

    public GoalType getType() {
        return this.type;
    }

    public abstract Object build(Object... objects);

    public enum GoalType{
        NMS,FOCESS;
    }
}
