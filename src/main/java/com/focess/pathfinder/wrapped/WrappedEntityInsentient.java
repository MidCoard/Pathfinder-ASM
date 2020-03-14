package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Mob;

public class WrappedEntityInsentient extends WrappedType {

    private final Object nmsMob;

    private WrappedEntityInsentient(Object nmsMob) {
        this.nmsMob = nmsMob;
    }

    public static WrappedEntityInsentient getWrappedEntityInsentient(Mob mob) {
        Object nmsMob = NMSManager.getNMSEntity(mob);
        return getWrappedEntityInsentient(nmsMob);
    }

    private static WrappedEntityInsentient getWrappedEntityInsentient(Object nmsMob) {
        if (NMSManager.getNMSClass("EntityInsentient").isAssignableFrom(nmsMob.getClass()))
            return new WrappedEntityInsentient(nmsMob);
        throw new ClassCastException(nmsMob.getClass().getTypeName() + " cannot be cast to " + WrappedEntityInsentient.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsMob;
    }
}
