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
}
