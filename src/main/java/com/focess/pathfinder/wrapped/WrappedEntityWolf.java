package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Wolf;

public class WrappedEntityWolf extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityWolf", true), WrappedEntityWolf.class);
    }

    private final Object nmsWolf;

    private WrappedEntityWolf(Object nmsWolf) {
        this.nmsWolf = nmsWolf;
    }

    public static WrappedEntityWolf getWrappedEntityWolf(Wolf wolf) {
        Object nmsWolf = NMSManager.getNMSEntity(wolf);
        return getWrappedEntityWolf(nmsWolf);
    }

    private static WrappedEntityWolf getWrappedEntityWolf(Object nmsWolf) {
        return new WrappedEntityWolf(nmsWolf);
    }

    @Override
    public Object toNMS() {
        return null;
    }
}
