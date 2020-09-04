package com.focess.pathfinder.core.util;

import com.focess.pathfinder.goal.Goal;

import java.util.EnumSet;

public class PathfinderUtil {

    public static EnumSet<Goal.Control> toFocessControls(int value, boolean isTarget) {
        EnumSet<Goal.Control> ret = EnumSet.noneOf(Goal.Control.class);
        if ((value & 1) == 1)
            if (isTarget)
                ret.add(Goal.Control.TARGET);
            else ret.add(Goal.Control.MOVE);
        if ((value & 2) == 2)
            ret.add(Goal.Control.LOOK);
        if ((value & 4) == 4)
            ret.add(Goal.Control.JUMP);
        return ret;
    }

    public static String styleUpperClassName(Class<?> c) {
        if (c.isPrimitive())
            return String.valueOf(c.getSimpleName().charAt(0)).toUpperCase() + c.getSimpleName().substring(1);
        if (c.isArray())
            return styleUpperClassName(c.getComponentType()) + "s";
        return c.getSimpleName();
    }

    public static String styleLowerClassName(Class<?> c) {
        if (c.isArray())
            return styleLowerClassName(c.getComponentType()) + "s";
        return String.valueOf(c.getSimpleName().charAt(0)).toLowerCase() + c.getSimpleName().substring(1);
    }

    public static Goal toGoal(Object goal) {
        return (Goal) goal;
    }
}
