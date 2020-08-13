package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class ZombieAttackGoalItem extends NMSGoalItem {
    protected ZombieAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalZombieAttack", true), 3, NMSManager.getNMSClass("EntityZombie", true), double.class, boolean.class);
    }

    public ZombieAttackGoalItem writeEntityZombie(com.focess.pathfinder.wrapped.WrappedEntityZombie arg) {
        this.write(0, arg);
        return this;
    }

    public ZombieAttackGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public ZombieAttackGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public ZombieAttackGoalItem clear() {
        return this;
    }
}