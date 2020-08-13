package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityInsentient;

public class PassengerCarrotStickGoalItem extends NMSGoalItem {

    protected PassengerCarrotStickGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalPassengerCarrotStick",true),2,NMSManager.getNMSClass("EntityInsentient",true),float.class);
    }

    public PassengerCarrotStickGoalItem writeEntityInsentient(WrappedEntityInsentient arg) {
        this.write(0,arg);
        return this;
    }

    public PassengerCarrotStickGoalItem writeFloat(float arg) {
        this.write(1,arg);
        return this;
    }


    @Override
    public PassengerCarrotStickGoalItem clear() {
        return this;
    }
}
