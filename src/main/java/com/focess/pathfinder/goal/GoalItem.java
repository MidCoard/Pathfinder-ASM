package com.focess.pathfinder.goal;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.List;

public abstract class  GoalItem {

    private final GoalType type;

    public EnumSet<Goal.Control> getControls() {
        return controls;
    }

    private EnumSet<Goal.Control> controls = EnumSet.noneOf(Goal.Control.class);
    protected List<Class<?>> parameters = Lists.newArrayList();

    public GoalItem(GoalType type) {
        this.type = type;
        if (this.type == GoalType.NMS)
            Goals.goalItems.add(this);
    }

    protected GoalItem addControl(Goal.Control control) {
        controls.add(control);
        return this;
    }

    protected GoalItem addParameters(Class<?>... classes) {
        for (Class<?> clz:classes)
            addParameter(clz);
        return this;
    }

    protected GoalItem addParameter(Class<?> clz) {
        parameters.add(clz);
        return this;
    }

    public GoalType getType() {
        return this.type;
    }

    protected GoalItem buildByGoal(Goal goal) {
        for (Goal.Control control:goal.getControls())
            this.addControl(control);
        return this;
    }

    public abstract Object build(Object... objects);

    public enum GoalType{
        NMS,FOCESS;
    }
}
