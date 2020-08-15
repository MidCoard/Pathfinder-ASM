package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class OfferFlowerGoalItem extends NMSGoalItem {
    protected OfferFlowerGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalOfferFlower", true), 1, NMSManager.getNMSClass("EntityIronGolem", true));
    }

    public OfferFlowerGoalItem writeEntityIronGolem(com.focess.pathfinder.wrapped.WrappedEntityIronGolem arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public OfferFlowerGoalItem clear() {
        return this;
    }
}