package com.focess.pathfinder.core.util;

import com.focess.pathfinder.goal.Goal;

import java.util.EnumSet;

public class PathfinderUtil {

    public static EnumSet<Goal.Control> toFocessControls(int value) {
        EnumSet<Goal.Control> ret = EnumSet.noneOf(Goal.Control.class);
        for (Goal.Control control: Goal.Control.values())
            if ((value &control.getValue()) == control.getValue())
                ret.add(control);
        return ret;
    }
}
