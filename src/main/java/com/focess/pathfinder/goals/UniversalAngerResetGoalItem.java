package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.*;
import org.bukkit.entity.LivingEntity;

import java.util.Objects;

public class UniversalAngerResetGoalItem extends NMSGoalItem {

    protected UniversalAngerResetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalUniversalAngerReset", true), 2, NMSManager.getNMSClass("EntityInsentient", true),boolean.class);
    }

    public UniversalAngerResetGoalItem writeEntityInsentient(WrappedEntityInsentientAndIEntityAngerable arg) {
        this.write(0, arg);
        return this;
    }

    public UniversalAngerResetGoalItem writeBoolean(boolean arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public NMSGoalItem clear() {
        return this;
    }

    public static class WrappedEntityInsentientAndIEntityAngerable extends WrappedType {

        private final Object nms;

        private WrappedEntityInsentientAndIEntityAngerable(Object nms) {
            this.nms = nms;
        }

        public static WrappedEntityInsentientAndIEntityAngerable getWrappedEntityInsentientAndIEntityAngerable(LivingEntity livingEntity) {
            WrappedEntityInsentient wrappedEntityInsentient = WrappedEntityInsentient.getWrappedEntityInsentient(livingEntity);
            WrappedIEntityAngerable iEntityAngerable = WrappedIEntityAngerable.getWrappedIEntityAngerable(livingEntity);
            if (Objects.equals(wrappedEntityInsentient.toNMS(), iEntityAngerable.toNMS()))
                return new WrappedEntityInsentientAndIEntityAngerable(wrappedEntityInsentient.toNMS());
            throw new IllegalArgumentException(livingEntity.getClass().getTypeName());
        }

        @Override
        public Object toNMS() {
            return this.nms;
        }
    }
}
