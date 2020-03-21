package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Skeleton;

public class WrappedEntitySkeletonAbstract extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntitySkeleton",true),WrappedEntitySkeleton.class);
    }

    private final Object nmsSkeleton;

    private WrappedEntitySkeletonAbstract(Object nmsSkeleton) {
        this.nmsSkeleton = nmsSkeleton;
    }

    public static WrappedEntitySkeletonAbstract getWrappedEntitySkeletonAbstract(Skeleton skeleton) {
        Object nmsSkeleton = NMSManager.getNMSEntity(skeleton);
        return getWrappedEntitySkeletonAbstract(nmsSkeleton);
    }

    private static WrappedEntitySkeletonAbstract getWrappedEntitySkeletonAbstract(Object nmsSkeleton) {
           return new WrappedEntitySkeletonAbstract(nmsSkeleton);
    }

    @Override
    public Object toNMS() {
        return this.nmsSkeleton;
    }
}
