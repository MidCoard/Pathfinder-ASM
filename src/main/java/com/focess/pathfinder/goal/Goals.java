package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.goal.util.NMSManager;
import com.google.common.collect.Lists;
import net.minecraft.server.v1_13_R1.IRangedEntity;

import java.util.Arrays;
import java.util.List;

public class Goals {

    protected static List<GoalItem> goalItems = Lists.newArrayList();

    public static class MOVE {
        public static final GoalItem ArrowAttack = new NMSGoalItem(NMSManager.getNMSClass("PathfinderGoalArrowAttack",true))
                .addControl(Goal.Control.MOVE).addControl(Goal.Control.LOOK)
                .addParameters(NMSManager.getNMSClass("IRangedEntity"),double.class,int.class,int.class,float.class);
    }

    public static class LOOK {

    }

    public static class JUMP {

    }

    public static class TARGET {

    }
}
