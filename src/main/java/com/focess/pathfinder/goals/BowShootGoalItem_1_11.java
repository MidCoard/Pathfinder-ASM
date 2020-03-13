package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntitySkeletonAbstract;

public class BowShootGoalItem_1_11 extends NMSGoalItem {
    protected BowShootGoalItem_1_11() {
        super(NMSManager.getNMSClass("PathfinderGoalBowShoot", true), 4, NMSManager.getNMSClass("EntityMonster", true), double.class, int.class, float.class);
    }

    public BowShootGoalItem_1_11 writeEntityMonster(WrappedEntitySkeletonAbstract arg) {
        this.write(0, arg);
        return this;
    }

    public BowShootGoalItem_1_11 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public BowShootGoalItem_1_11 writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    public BowShootGoalItem_1_11 writeFloat(float arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public BowShootGoalItem_1_11 clear() {
        return this;
    }
}