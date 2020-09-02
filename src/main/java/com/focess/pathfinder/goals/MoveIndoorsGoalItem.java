package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityCreature;

public class MoveIndoorsGoalItem extends NMSGoalItem {

    protected MoveIndoorsGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalMoveIndoors", true), 1, NMSManager.getNMSClass("EntityCreature", true));
    }

    public MoveIndoorsGoalItem writeEntityCreature(WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public MoveIndoorsGoalItem clear() {
        return this;
    }
}
