package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Tameable;

public class WrappedEntityPerchable extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityPerchable", true), WrappedEntityPerchable.class);
    }

    private final Object nmsTameable;

    private WrappedEntityPerchable(Object nmsTameable) {
        this.nmsTameable = nmsTameable;
    }

    @Override
    public Object toNMS() {
        return null;
    }

    public static WrappedEntityPerchable getWrappedEntityPerchable(Tameable tameable) {
        Object nmsTameable = NMSManager.getNMSEntity(tameable);
        return getWrappedEntityPerchable(nmsTameable);
    }

    private static WrappedEntityPerchable getWrappedEntityPerchable(Object nmsTameable) {
        if (NMSManager.getNMSClass("EntityPerchable").isAssignableFrom(nmsTameable.getClass()))
            return new WrappedEntityPerchable(nmsTameable);
        throw new ClassCastException(nmsTameable.getClass().getTypeName() + " cannot be cast to " + WrappedEntityCreature.class.getTypeName());
    }
}
