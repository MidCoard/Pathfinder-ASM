package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class OcelotAttackGoalItem extends NMSGoalItem {
    protected OcelotAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalOcelotAttack", true), 1, NMSManager.getNMSClass("EntityInsentient", true));
    }

    public OcelotAttackGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public OcelotAttackGoalItem clear() {
        return this;
    }
}