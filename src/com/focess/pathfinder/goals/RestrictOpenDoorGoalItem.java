package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityCreature;

public class RestrictOpenDoorGoalItem extends NMSGoalItem  {
    public RestrictOpenDoorGoalItem(){
        super(NMSManager.getNMSClass("PathfinderGoalRestrictOpenDoor",true),1,NMSManager.getNMSClass("EntityCreature"));
    }

    public RestrictOpenDoorGoalItem writeEntityCreature(WrappedEntityCreature arg) {
        this.write(0,arg);
        return this;
    }

    @Override
    public RestrictOpenDoorGoalItem clear() {
        return this;
    }
}
