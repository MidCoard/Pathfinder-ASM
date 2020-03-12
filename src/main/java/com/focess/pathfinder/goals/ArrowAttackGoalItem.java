package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedIRangedEntity;

public class ArrowAttackGoalItem extends NMSGoalItem {

    protected ArrowAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalArrowAttack", true), 5,
                NMSManager.getNMSClass("IRangedEntity", true), double.class, int.class, int.class, float.class);
    }

    public ArrowAttackGoalItem writeIRangedEntity(WrappedIRangedEntity entity) {
        this.write(0, entity);
        return this;
    }

    public ArrowAttackGoalItem writeDouble(double d) {
        this.write(1, d);
        return this;
    }

    private PointerWriter intWriter = new PointerWriter(2, 2);

    public ArrowAttackGoalItem writeInt(int i) {
        intWriter.write(i);
        return this;
    }

    public ArrowAttackGoalItem writeFloat(float f) {
        this.write(4, f);
        return this;
    }


    @Override public ArrowAttackGoalItem clear() {
        intWriter.clear();
        return this;
    }
}
