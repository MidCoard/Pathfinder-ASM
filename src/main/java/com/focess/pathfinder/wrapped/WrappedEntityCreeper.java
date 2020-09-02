package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Creeper;

public class WrappedEntityCreeper extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityCreeper"), WrappedEntityCreeper.class);
    }

    private final Object nmsCreeper;

    private WrappedEntityCreeper(Object nmsCreeper) {
        this.nmsCreeper = nmsCreeper;
    }

    public static WrappedEntityCreeper getWrappedEntityCreeper(Creeper creeper) {
        Object nmsCreeper = NMSManager.getNMSEntity(creeper);
        return getWrappedEntityCreeper(nmsCreeper);
    }

    private static WrappedEntityCreeper getWrappedEntityCreeper(Object nmsCreeper) {
        return new WrappedEntityCreeper(nmsCreeper);
    }

    @Override
    public Object toNMS() {
        return this.nmsCreeper;
    }
}
