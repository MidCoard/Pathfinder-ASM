package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Creature;

public class WrappedEntityCreature extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityCreature",true),WrappedEntityCreature.class);
    }

    private final Object nmsCreature;

    private WrappedEntityCreature(Object nmsCreature) {
        this.nmsCreature = nmsCreature;
    }

    @Override
    public Object toNMS() {
        return this.nmsCreature;
    }

    public static WrappedEntityCreature getWrappedEntityCreature(Creature creature) {
        Object nmsCreature = NMSManager.getNMSEntity(creature);
        return getWrappedEntityCreature(nmsCreature);
    }

    private static WrappedEntityCreature getWrappedEntityCreature(Object nmsCreature) {
        if (NMSManager.getNMSClass("EntityCreature").isAssignableFrom(nmsCreature.getClass()))
            return new WrappedEntityCreature(nmsCreature);
        throw new ClassCastException(nmsCreature.getClass().getTypeName() + " cannot be cast to " + WrappedEntityCreature.class.getTypeName());
    }

}
