package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.goal.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedIRangedEntity;

import java.awt.*;

public class ArrowAttackGoalItem extends NMSGoalItem {

    public ArrowAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalArrowAttack",true),5);
    }

    public ArrowAttackGoalItem writeIRangedEntity(WrappedIRangedEntity entity) {
        this.write(0,entity);
        return this;
    }

    public ArrowAttackGoalItem writeDouble(double d) {
        this.write(1,d);
        return this;
    }

    private PointerWriter intWriter = new PointerWriter(2,2);

    public ArrowAttackGoalItem writeInt(int i) {
        intWriter.write(i);
        return this;
    }

    public ArrowAttackGoalItem writeFloat(float f) {
        this.write(4,f);
        return this;
    }
}
