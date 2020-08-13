package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityVillager;

public class PlayGoalItem extends NMSGoalItem {

    protected PlayGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalPlay",true),2,NMSManager.getNMSClass("EntityVillager",true),double.class);
    }

    public PlayGoalItem writeEntityVillager(WrappedEntityVillager arg){
        this.write(0,arg);
        return this;
    }

    public PlayGoalItem writeDouble(double arg) {
        this.write(1,arg);
        return this;
    }

    @Override
    public PlayGoalItem clear() {
        return this;
    }
}
