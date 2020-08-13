package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class MeleeAttackGoalItem extends NMSGoalItem {
    protected MeleeAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalMeleeAttack", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, boolean.class);
    }

    public MeleeAttackGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public MeleeAttackGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public MeleeAttackGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public MeleeAttackGoalItem clear() {
        return this;
    }
}