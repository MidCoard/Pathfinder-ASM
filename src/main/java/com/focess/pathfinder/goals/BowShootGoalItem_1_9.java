package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntitySkeleton;

public class BowShootGoalItem_1_9 extends NMSGoalItem {
    protected BowShootGoalItem_1_9() {
        super(NMSManager.getNMSClass("PathfinderGoalBowShoot", true), 4, NMSManager.getNMSClass("EntitySkeleton", true), double.class, int.class, float.class);
    }

    public BowShootGoalItem_1_9 writeEntityMonster(WrappedEntitySkeleton arg) {
        this.write(0, arg);
        return this;
    }

    public BowShootGoalItem_1_9 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public BowShootGoalItem_1_9 writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    public BowShootGoalItem_1_9 writeFloat(float arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public BowShootGoalItem_1_9 clear() {
        return this;
    }

}