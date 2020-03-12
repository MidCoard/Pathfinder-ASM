package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BowShootGoalItem extends NMSGoalItem {
    protected BowShootGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalBowShoot", true), 4, NMSManager.getNMSClass("EntityMonster", true), double.class, int.class, float.class);
    }

    public BowShootGoalItem writeEntityMonster(T arg) {
        this.write(0, arg);
        return this;
    }

    public BowShootGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public BowShootGoalItem writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    public BowShootGoalItem writeFloat(float arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public BowShootGoalItem clear() {
        return this;
    }
}