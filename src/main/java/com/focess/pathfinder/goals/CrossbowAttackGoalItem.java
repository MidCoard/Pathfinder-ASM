package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class CrossbowAttackGoalItem extends NMSGoalItem {
    protected CrossbowAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalCrossbowAttack", true), 3, NMSManager.getNMSClass("EntityMonster", true), double.class, float.class);
    }

    public CrossbowAttackGoalItem writeEntityMonster(T arg) {
        this.write(0, arg);
        return this;
    }

    public CrossbowAttackGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public CrossbowAttackGoalItem writeFloat(float arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public CrossbowAttackGoalItem clear() {
        return this;
    }
}