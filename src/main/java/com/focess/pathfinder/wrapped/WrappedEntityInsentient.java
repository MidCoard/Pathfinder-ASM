package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Mob;

public class WrappedEntityInsentient extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityInsentient",true),WrappedEntityInsentient.class);
    }

    private final Object nmsMob;

    private WrappedEntityInsentient(Object nmsMob) {
        this.nmsMob = nmsMob;
    }

    public static WrappedEntityInsentient getWrappedEntityInsentient(Mob mob) {
        Object nmsMob = NMSManager.getNMSEntity(mob);
        return getWrappedEntityInsentient(nmsMob);
    }

    private static WrappedEntityInsentient getWrappedEntityInsentient(Object nmsMob) {
            return new WrappedEntityInsentient(nmsMob);
    }

    @Override
    public Object toNMS() {
        return this.nmsMob;
    }
}
