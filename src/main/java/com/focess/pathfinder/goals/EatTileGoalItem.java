package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class EatTileGoalItem extends NMSGoalItem {
    protected EatTileGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalEatTile", true), 1, NMSManager.getNMSClass("EntityInsentient", true));
    }

    public EatTileGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public EatTileGoalItem clear() {
        return this;
    }
}