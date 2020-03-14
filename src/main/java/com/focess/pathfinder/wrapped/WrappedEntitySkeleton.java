package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Skeleton;

public class WrappedEntitySkeleton extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntitySkeleton",true),WrappedEntitySkeleton.class);
    }

    private final Object nmsSkeleton;

    private WrappedEntitySkeleton(Object nmsSkeleton) {
        this.nmsSkeleton = nmsSkeleton;
    }

    public static WrappedEntitySkeleton getWrappedEntitySkeleton(Skeleton skeleton) {
        Object nmsSkeleton = NMSManager.getNMSEntity(skeleton);
        return getWrappedEntitySkeleton(nmsSkeleton);
    }

    private static WrappedEntitySkeleton getWrappedEntitySkeleton(Object nmsSkeleton) {
        if (NMSManager.getNMSClass("EntitySkeleton").isAssignableFrom(nmsSkeleton.getClass()))
            return new WrappedEntitySkeleton(nmsSkeleton);
        throw new ClassCastException(nmsSkeleton.getClass().getTypeName() + " cannot be cast to " + WrappedEntitySkeleton.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsSkeleton;
    }
}
