package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityMonster;
import com.focess.pathfinder.wrapped.WrappedIRangedEntity;
import com.focess.pathfinder.wrapped.WrappedType;
import org.bukkit.entity.Monster;

import java.util.Objects;

public class BowShootGoalItem_1_12 extends NMSGoalItem {
    protected BowShootGoalItem_1_12() {
        super(NMSManager.getNMSClass("PathfinderGoalBowShoot", true), 4, NMSManager.getNMSClass("EntityMonster", true), double.class, int.class, float.class);
    }

    public BowShootGoalItem_1_12 writeEntityMonster(WrappedEntityMonsterAndIRangedEntity arg) {
        this.write(0, arg);
        return this;
    }

    public BowShootGoalItem_1_12 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public BowShootGoalItem_1_12 writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    public BowShootGoalItem_1_12 writeFloat(float arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public BowShootGoalItem_1_12 clear() {
        return this;
    }

    public static class WrappedEntityMonsterAndIRangedEntity extends WrappedType {

        private final Object nms;

        private WrappedEntityMonsterAndIRangedEntity(Object nms){
            this.nms = nms;
        }

        @Override
        public Object toNMS() {
            return this.nms;
        }

        public static WrappedEntityMonsterAndIRangedEntity getWrappedEntityMonsterAndIRangedEntity(Monster monster) {
            WrappedEntityMonster wrappedEntityMonster = WrappedEntityMonster.getWrappedEntityMonster(monster);
            WrappedIRangedEntity iRangedEntity = WrappedIRangedEntity.getWrappedIRangedEntity(monster);
            if (Objects.equals(wrappedEntityMonster.toNMS(), iRangedEntity.toNMS()))
                return new WrappedEntityMonsterAndIRangedEntity(wrappedEntityMonster.toNMS());
            throw new IllegalArgumentException(monster.getClass().getTypeName());
        }
    }
}