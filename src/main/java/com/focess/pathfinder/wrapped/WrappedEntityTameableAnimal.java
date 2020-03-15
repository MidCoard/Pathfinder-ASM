package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Tameable;

public class WrappedEntityTameableAnimal extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityTameableAnimal",true),WrappedEntityTameableAnimal.class);
    }

    private final Object nmsTameable;

    private WrappedEntityTameableAnimal(Object nmsTameable) {
        this.nmsTameable = nmsTameable;
    }

    public static WrappedEntityTameableAnimal getWrappedEntityTameableAnimal(Tameable tameable) {
        Object nmsTameable = NMSManager.getNMSEntity(tameable);
        return getWrappedEntityTameableAnimal(nmsTameable);
    }

    private static WrappedEntityTameableAnimal getWrappedEntityTameableAnimal(Object nmsTameable) {
        if (NMSManager.getNMSClass("EntityTameableAnimal").isAssignableFrom(nmsTameable.getClass()))
            return new WrappedEntityTameableAnimal(nmsTameable);
        throw new ClassCastException(nmsTameable.getClass().getTypeName() + " cannot be cast to " + WrappedEntityTameableAnimal.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsTameable;
    }
}
